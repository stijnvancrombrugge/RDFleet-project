package com.realdolmen.fleet.web.Tasks;

import com.realdolmen.fleet.model.domain.Car;
import com.realdolmen.fleet.model.domain.CurrentCar;
import com.realdolmen.fleet.model.domain.Order;
import com.realdolmen.fleet.model.domain.Status;
import com.realdolmen.fleet.repositories.repository.CarRepository;
import com.realdolmen.fleet.repositories.repository.CurrentCarRepository;
import com.realdolmen.fleet.repositories.repository.OrderRepository;
import com.realdolmen.fleet.services.CurrentCarService;
import com.realdolmen.fleet.services.MailService;
import com.realdolmen.fleet.services.OrderService;
import com.realdolmen.fleet.services.util.DateUtil;
import com.realdolmen.fleet.web.Factory.MailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Created by SDOAX36 on 5/11/2015.
 */
@Component
public class KilometerScheduler {

    @Autowired
    CarRepository repository;

    @Autowired
    CurrentCarService currentCarService;

    @Autowired
    MailService mailService;

    @Autowired
    OrderService orderService;

    @Scheduled(fixedRate = 360000)
    public void addRandomKilometersToCar() {
        iterateList();
    }

//every 200 seconds we are going to perform a lottery
    @Scheduled(fixedRate = 200)
    public void orderChecker()
    {
        checkOrdersApproved();
    }

    private void checkOrdersApproved()
    {
       List<Order>orders = orderService.getAllOrdersByStatus(Status.APPROVED);
        Random random = new Random();
        Order order = orderService.orderToFleet(orders.get(random.nextInt(orders.size() - 1)));
        currentCarService.createNewCurrentCarFromOrder(order);

    }

    private void iterateList() {
        for (Car c : repository.findAll()) {

            int km = randomKilometers();
            c.setKilometers(c.getKilometers() + randomKilometers());
            System.out.println("Car " + c.getId() + " km + " + km);
            repository.save(c);
            timeToRenew(c);
        }
    }

    private int randomKilometers() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    public void timeToRenew(Car car) {
        CurrentCar currentCar = currentCarService.findByCar(car);
        if (currentCar != null) {
            if (currentCarService.isCarAlmostDone(currentCar) && !currentCar.isRenewMailSend()) {
                //if employee uses this car, send him a mail with a new ordercode
                if (currentCar.getEmployee() != null) {
                    sendRenewalMail(currentCar);

                }
                //else means it is a freefleet car, let's lose this car without any notice for now
                else
                {
                    currentCarService.removeCurrentCar(currentCar);
                }
            }
            //do nothing
        }
        //do nothing
    }


    public void sendRenewalMail(CurrentCar car) {

        car.setRenewMailSend(true);
        Order order = orderService.saveNewOrder(car.getEmployee());
        mailService.sendMail(car.getEmployee().getEmail(), MailFactory.CAR_RENEW_MESSAGE, MailFactory.createCarRenewMail(car.getEmployee().getFirstName(), order.getOrderCode(), ""));
        currentCarService.currentCarMailIsSent(car);
    }
}
