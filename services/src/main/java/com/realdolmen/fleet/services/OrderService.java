package com.realdolmen.fleet.services;

import com.realdolmen.fleet.model.domain.Order;
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




}
