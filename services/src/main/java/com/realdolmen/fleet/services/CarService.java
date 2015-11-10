package com.realdolmen.fleet.services;

import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.Car;
import com.realdolmen.fleet.repositories.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by SVCAX33 on 5/11/2015.
 */

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public void addNewCar(Car car){
       carRepository.save(car);
    }


}
