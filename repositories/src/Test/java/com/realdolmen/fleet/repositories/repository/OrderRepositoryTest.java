package com.realdolmen.fleet.repositories.repository;



import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.*;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;
import sun.font.LayoutPathImpl;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
public class OrderRepositoryTest extends AbstractRepoTest {

    private int idToCheckFirst,idToCheckSecond,idToCheckThird;
    private String code1,code2,code3;

    private Employee employeeToCheck1,employeeToCheck2;

//TODO : order is changed so we need to change the code
    @Override
    public void setUp() throws Exception {
      /*  Order order1 = new Order(new Car(new CarModel("A1","Audi",140,1400,11,5,11,"Ecoline",new Category(1)),"Yellow",0,"EES-456",0));
        getOrderRepository().save(order1);
        idToCheckFirst = order1.getId();
        code1 = order1.getOrderCode();
        System.out.println("Order code 1 = " + order1.getOrderCode());
        Order order2 = new Order(new Car(new CarModel("A1","Volkswagen",140,1400,11,5,11,"Ecoline",new Category(1)),"Yellow",0,"EES-456",0));
        getOrderRepository().save(order2);
        idToCheckSecond = order2.getId();
        code2 = order2.getOrderCode();
        System.out.println("Order code 2 = " + order2.getOrderCode());
*/
        Employee employee = new Employee("steven.decock121","test","steven.decock@realdolmen.com",new Category(1),"steven","De Cock");
        getUserRepository().save(employee);
        Order order = new Order(employee);
        getOrderRepository().save(order);
        Employee employee1 = new Employee("steven.decock122","test","steven.decock@realdolmen.com",new Category(1),"steven","De Cock");
        getUserRepository().save(employee1);
        Order order1 = new Order(employee1);
        order1.setStatus(Status.APPROVED);
        getOrderRepository().save(order1);
        Employee employee2 = new Employee("steven.decock123","test","steven.decock@realdolmen.com",new Category(1),"steven","De Cock");
        getUserRepository().save(employee2);
        Order order2 = new Order(employee2);
        order2.setCar(new Car(new CarModel("A1", "Audi", 140, 1400, 11, 5, 11, "Ecoline", new Category(1)), "Yellow", 0, "EES-456", 0));
        getOrderRepository().save(order2);
        code1 = order.getOrderCode();
        code3 = order2.getOrderCode();
        idToCheckThird = order2.getId();
        idToCheckFirst = order.getId();
        code2 = order1.getOrderCode();
        employeeToCheck1 = employee;
        employeeToCheck2 = employee2;

    }

    @Override
    public void shouldCreateEntity() throws Exception {
/*
        int size = getOrderRepository().findAll().size();
        Order order1 = new Order(new Car(new CarModel("A1","Audi",140,1400,11,5,11,"Ecoline",new Category(1)),"Yellow",0,"EES-456",0));
        getOrderRepository().save(order1);
        System.out.println("order id = "+order1.getId()+" car id = "+order1.getCar().getId());
        assertNotNull(order1.getId());
        assertEquals(getOrderRepository().findAll().size(), size + 1);
        */
        Employee employee = new Employee("steven.decock","test","steven.decock@realdolmen.com",new Category(1),"steven","De Cock");
        getUserRepository().save(employee);
        Order order = new Order(employee);
        getOrderRepository().save(order);
        assertNotNull(order.getOrderCode());

    }

    @Override
    public void shouldReturnOnlyOneEntityById() throws Exception {

        Order order = getOrderRepository().findOne(idToCheckFirst);
        assertEquals(order.getOrderCode(), code1);

        Order order1 = getOrderRepository().findOne(idToCheckSecond);
        assertEquals(order1.getOrderCode(), code2);
    }

    @Override
    public void shouldReturnAllEntities() throws Exception {
        assertEquals(getOrderRepository().findAll().size(),2);

    }

    @Override
    public void shouldUpdateAnEntity() throws Exception {

        Order order = getOrderRepository().findOne(idToCheckFirst);
        order.setOrderDate(new Date());
        assertEquals(getOrderRepository().findOne(idToCheckFirst).getOrderDate(), order.getOrderDate());
    }

    @Override
    public void shouldDeleteAnEntity() throws Exception {
        int size = getOrderRepository().findAll().size();
        getOrderRepository().delete(idToCheckFirst);
        assertNull(getOrderRepository().findOne(idToCheckFirst));
        assertEquals(getOrderRepository().findAll().size(),size -1);
    }

    @Test
    public void shouldDeleteAnEntityButNotTheCar()throws Exception
    {
        int sizeCars = getCarRepository().findAll().size();
        int sizeOrder = getOrderRepository().findAll().size();
        Order order = getOrderRepository().findOne(idToCheckFirst);
        Car car = order.getCar();
        getOrderRepository().delete(idToCheckFirst);
        assertNull(getOrderRepository().findOne(idToCheckFirst));
        assertEquals(getOrderRepository().findAll().size(), sizeOrder - 1);
        assertNotNull(getCarRepository().findOne(car.getId()));
        assertEquals(getCarRepository().findAll().size(),sizeCars);
    }


    @Test
    public void shouldReturnListOfOrdersFromOneMark()
    {
        List<Order> orders = getOrderRepository().findAllByCarCarModelMark("Audi");
        assertEquals(orders.size(), 1);
        assertNotSame(orders.size(), getOrderRepository().findAll());
    }

    @Test
    public void shouldReturnOrderByOrderCodeEmployeeAndStatus()
    {
        Optional<Order> order = getOrderRepository().findByOrderCodeAndEmployeeAndStatusAndCarIsNull(code1, employeeToCheck1, Status.PENDING);
        assertNull(order.get());

    }

    @Test(expected = NoSuchElementException.class)
    public void shouldNotReturnOrderByCodeAndEmployeeAndStatus()
    {
        Optional<Order>orderFalse = getOrderRepository().findByOrderCodeAndEmployeeAndStatusAndCarIsNull(code1, employeeToCheck1, Status.APPROVED);
        assertFalse(orderFalse.isPresent());
        assertNull(orderFalse.get());
    }


}
