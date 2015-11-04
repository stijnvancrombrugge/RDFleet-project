package com.realdolmen.fleet.services;

import com.realdolmen.fleet.model.domain.CurrentCar;
import com.realdolmen.fleet.repositories.repository.CurrentCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDOAX36 on 3/11/2015.
 */
@Service
public class CurrentCarService {

    @Autowired
    CurrentCarRepository currentCarRepository;

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
}
