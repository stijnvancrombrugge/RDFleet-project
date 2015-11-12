package com.realdolmen.fleet.services;

import com.realdolmen.fleet.model.domain.*;
import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.repositories.repository.*;
import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.model.domain.Order;
import com.realdolmen.fleet.model.domain.Status;
import com.realdolmen.fleet.model.domain.*;
import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.repositories.repository.CarRepository;
import com.realdolmen.fleet.repositories.repository.CurrentCarRepository;
import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.model.domain.Order;
import com.realdolmen.fleet.model.domain.Status;
import com.realdolmen.fleet.repositories.repository.CurrentCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by SDOAX36 on 3/11/2015.
 */
@Service
public class OrderService {


    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public CurrentCarRepository currentCarRepository;

    @Autowired
    public CarRepository carRepository;


    public void orderNewCar(List<Option> optionList, CarModel carModel, String color, Order order){
        List<CurrentCar> existingCars = currentCarRepository.findByCarCarModelMarkAndCarCarModelModelAndCarColorAndEmployeeIsNull(carModel.getMark(), carModel.getModel(), color);
        Car orderedCar;

        if(existingCars.isEmpty()){
            orderedCar = new Car(carModel, color, 0, "", 0);
        }
        else{
            orderedCar = existingCars.get(0).getCar();
            orderedCar.getOptionPacks().clear();
        }
        OptionPack optionPack = new OptionPack("basic pack");
        optionPack.setOptions(optionList);
        orderedCar.addOptionPack(optionPack);
        order.setCar(orderedCar);
        order.setStatus(Status.CAR_CHOSEN);
        orderRepository.saveAndFlush(order);
        carRepository.save(orderedCar);

    }



    public List<Order> getAllOrders()
    {

        return orderRepository.findAll();
    }

    public Order getOrderForId(Integer id)
    {
        return orderRepository.findOne(id);
    }

    public List<Order> getAllOrdersOrderByDate()
    {
        return orderRepository.findAllByOrderByOrderDateAsc();
    }

    public List<Order> getAllOrdersForMark(String s)
    {
        return orderRepository.findAllByCarCarModelMark(s);

    }
    public int getAllOrdersForMarkCount(String s)
    {
        return getAllOrdersForMark(s).size();
    }


    public Order saveNewOrder(Employee employee)
    {
        Order order = new Order(employee);
        orderRepository.saveAndFlush(order);
        return order;
    }

    public Order getOrderByOrderCode(String orderCode)
    {
        Optional<Order> optional = orderRepository.findByOrderCode(orderCode);
        if(optional.isPresent())
        {
            return optional.get();
        }
        return null;
    }

    /**
     *
     * @param orderCode
     * @param employee
     * @return Order if present
     * @throws NoSuchElementException No Element found for these params
     */
    public Order getOrderWhereEmployeeForApproval(String orderCode,Employee employee)throws NoSuchElementException
    {
        Optional<Order>optional = orderRepository.findByOrderCodeAndEmployeeAndStatusAndCarIsNull(orderCode,employee,Status.PENDING);
        if(optional.isPresent()) {
            return optional.get();
        }
        else return null;
    }

    public List<Order>getAllOrdersByStatus(Status status)
    {
        return orderRepository.findAllByStatus(status);
    }

    public int getSizeOfListByStatus(Status status)
    {
        return getAllOrdersByStatus(status).size();
    }

    public Order approveOrder(Integer id)
    {
        Order order = getOrderForId(id);
        order.setStatus(Status.APPROVED);
        order.setManagerGoedDate(new Date());
        orderRepository.saveAndFlush(order);
        return order;
    }

    public Order carChoosenOrder(Integer id)
    {
        Order order = getOrderForId(id);
        order.setStatus(Status.CAR_CHOOSEN);
        orderRepository.saveAndFlush(order);
        return order;
    }

    public Order deniedOrder(Integer id,String comment)
    {
        Order order = getOrderForId(id);
        order.setStatus(Status.DENIED);
        order.setManagerGoedDate(new Date());
        order.setCommentFromManager(comment);
        orderRepository.saveAndFlush(order);
        return order;
    }

    public Order orderToFleet(Order order)
    {

        order.setStatus(Status.POOL);
        orderRepository.saveAndFlush(order);
        return order;
    }

    public void removeOrder(int carId, int employeeId){
        Optional order = orderRepository.findByCarAndEmployee(carRepository.findOne(carId), (Employee) userRepository.findOne(employeeId));
        if(order.isPresent()){
            orderRepository.delete((Order)order.get());
        }
    }



}
