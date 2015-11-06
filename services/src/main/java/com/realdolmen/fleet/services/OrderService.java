package com.realdolmen.fleet.services;

import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.*;
import com.realdolmen.fleet.repositories.repository.CarRepository;
import com.realdolmen.fleet.repositories.repository.CurrentCarRepository;
import com.realdolmen.fleet.repositories.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDOAX36 on 3/11/2015.
 */
@Service
public class OrderService {


    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public CurrentCarRepository currentCarRepository;

    @Autowired
    public CarRepository carRepository;


    public void orderNewCar(List<Option> optionList, CarModel carModel, String color, Employee employee){
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
        return orderRepository.findAllByCarCarModelMark(s.toLowerCase());

    }
    public int getAllOrdersForMarkCount(String s)
    {
        return orderRepository.findAllByCarCarModelMark(s.toLowerCase()).size();
    }




}
