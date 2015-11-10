package com.realdolmen.fleet.services;

import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.*;
import com.realdolmen.fleet.repositories.repository.CurrentCarRepository;
import com.realdolmen.fleet.repositories.repository.UserRepository;
import com.realdolmen.fleet.services.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.spi.CurrencyNameProvider;

/**
 * Created by SDOAX36 on 3/11/2015.
 */
@Service
public class CurrentCarService {

    @Autowired
    CurrentCarRepository currentCarRepository;

    @Autowired
    UserRepository userRepository;


    public List<CurrentCar>getAllCurrentCarsFromFleet()
    {
        return currentCarRepository.findAll();
    }

    public int getCountAllCurrentCars()
    {
        return getAllCurrentCarsFromFleet().size();
    }

    public CurrentCar getCurrentCarById(int id)
    {
        return currentCarRepository.findOne(id);
    }

    public List<CurrentCar>getAllActiveCurrentCars()
    {
        return currentCarRepository.findByEmployeeIsNotNull();
    }

    public int getActiveFleetCount()
    {
        return getAllActiveCurrentCars().size();
    }

    public List<CurrentCar>getAllFreeFleetCars()
    {
        return currentCarRepository.findByEmployeeIsNull();
    }

    public int getFreeFleetCount()
    {
        return getAllFreeFleetCars().size();
    }

    public List<CurrentCar> getCarsByMarkFreePool(String mark)
    {
        return currentCarRepository.findByCarCarModelMarkAndEmployeeIsNull(mark);
    }

    public List<CurrentCar> getCarsByMarkActiveFleet(String mark)
    {
        return currentCarRepository.findByCarCarModelMarkAndEmployeeIsNotNull(mark);
    }

    public int getCountFromFreePoolByMark(String mark)
    {
        return getCarsByMarkFreePool(mark).size();
    }
    public int getCountFromActivePoolByMark(String mark)
    {
        return getCarsByMarkActiveFleet(mark).size();
    }

    public List<CurrentCar> getCarsByModelFreePool(String model)
    {
        return currentCarRepository.findByCarCarModelModelAndEmployeeIsNull(model);
    }
    public List<CurrentCar> getCarsByModelActivePool(String model)
    {
        return currentCarRepository.findByCarCarModelModelAndEmployeeIsNotNull(model);
    }
    public int getCountModelFreePool(String model)
    {
        return getCarsByModelFreePool(model).size();
    }
    public int getCountModelActivePool(String model)
    {
        return getCarsByModelFreePool(model).size();
    }

    public List<CurrentCar> getCarsAlmostDone()
    {
        List<CurrentCar> cars = new ArrayList<>();
        for(CurrentCar car : getAllCurrentCarsFromFleet())
        {
            if(isCarAlmostDone(car))
            {
                cars.add(car);
            }
        }

        return cars;

    }

    public void removeCurrentCar(CurrentCar currentCar)
    {
        currentCarRepository.delete(currentCar);
    }

    public void createNewCurrentCarFromOrder(Order order)
    {
        CurrentCar c = new CurrentCar(order.getCar());
        c.setEmployee(order.getEmployee());
        currentCarRepository.saveAndFlush(c);
    }

    public CurrentCar findByCar(Car car)
    {
        return currentCarRepository.findByCar(car).get();
    }

    public boolean isCarAlmostDone(CurrentCar car)
    {
        Date endLeasing = DateUtil.calculateEndLease(car.getLeasingStartDate());
        Date now = new Date();
        long diff = endLeasing.getTime() - now.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        if(diffDays<120L)
        {
            return true;
        }
        else if((160000 - car.getCar().getKilometers())<500)
        {
            return true;
        }
        return false;
    }

    public void currentCarMailIsSent(CurrentCar currentCar)
    {
        currentCar.setRenewMailSend(true);
        currentCarRepository.saveAndFlush(currentCar);
    }
}
