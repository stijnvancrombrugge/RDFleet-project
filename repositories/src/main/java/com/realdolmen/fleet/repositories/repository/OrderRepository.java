package com.realdolmen.fleet.repositories.repository;

import com.realdolmen.fleet.model.domain.Car;
import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.model.domain.Order;
import com.realdolmen.fleet.model.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
public interface OrderRepository extends JpaRepository<Order,Integer> {
    public List<Order>findAllByOrderByOrderDateAsc();

    final static String QUERY_BY_MARK = "Select o From Order o Where o.car.carModel.mark like :mark";
    @Query(QUERY_BY_MARK)
    public List<Order>findAllByCarCarModelMark(@Param("mark")String mark);

    @Query("select o from Order o where o.car.carModel.model like :model")
    public List<Order>findAllByCarCarModelModel(@Param("model")String model);

    public Optional<Order>findByOrderCodeAndEmployeeAndStatusAndCarIsNull(String orderCode,Employee employee,Status status);

    public List<Order>findAllByStatus(Status status);

    public Optional<Order>findByCarAndEmployee(Car car, Employee employee);

    public Optional<Order>findByOrderCode(String orderCode);
}
