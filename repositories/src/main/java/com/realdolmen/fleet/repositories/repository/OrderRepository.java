package com.realdolmen.fleet.repositories.repository;


import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.model.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
