package com.realdolmen.fleet.services;

import com.realdolmen.fleet.model.domain.Order;
import com.realdolmen.fleet.repositories.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SDOAX36 on 3/11/2015.
 */
@Service
public class OrderService {


    @Autowired
    OrderRepository orderRepository;


    public List<Order> getAllOrders()
    {
        return orderRepository.findAll();
    }

    public Order getOrderForId(Integer id)
    {
        return orderRepository.findOne(id);
    }



}
