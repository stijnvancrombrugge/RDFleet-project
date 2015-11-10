package com.realdolmen.fleet.services;

import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.model.domain.Order;
import com.realdolmen.fleet.model.domain.Status;
import com.realdolmen.fleet.model.domain.User;
import com.realdolmen.fleet.repositories.repository.OrderRepository;
import com.realdolmen.fleet.repositories.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDOAX36 on 2/11/2015.
 */
@Service
public class EmployeeService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public OrderRepository orderRepository;

    public List<Employee> findAllEmployees()
    {
        List<Employee>employees = new ArrayList<>();
        for(User u : userRepository.findAll())
        {
            if(u instanceof Employee)
            {
                employees.add((Employee)u);
            }
        }
        return employees;
    }

    public Employee findEmployeeById(Integer id)throws Exception
    {
        return (Employee)userRepository.findOne(id);
    }

    public boolean isEmployeePresent(String username)
    {
        //No need to cast this shit, if the user exists give true
        return userRepository.findByUsername(username).isPresent();
    }

    public void saveEmployee(Employee employee)
    {
        userRepository.save(employee);

    }

    public List<Employee> findEmployeesToOrder()
    {
       List<Employee> employees = findAllEmployees();
        List<Employee>employeeListToRemove = new ArrayList<>();
       for(Employee e : employees)
       {
           if(e.getCurrentCar() != null)
           {
               employeeListToRemove.add(e);
           }
           else {
               List<Boolean> orderList = new ArrayList<>();
               for (Order o : e.getOrders()) {
                   if (o.getStatus().equals(Status.PENDING)) {
                       orderList.add(true);
                   } else {
                       orderList.add(false);
                   }
               }
               if (orderList.contains(true)) {
                   employeeListToRemove.add(e);
               }
           }
       }
        employees.removeAll(employeeListToRemove);

        return employees;
    }

    /**
     *
     * @param empId
     * @param order
     * @return Integer orderId
     */
    public Integer addNewOrder(Integer empId,Order order)
    {
        try
        {
           Employee e = (Employee)userRepository.findOne(empId);
            e.addOrder(order);
            userRepository.saveAndFlush(e);
            return order.getId();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    public void removeEmployeeById(Integer empId){
        Employee employee = (Employee) userRepository.findOne(empId);
        if(employee.getCurrentCar() != null){
           employee.getCurrentCar().setEmployee(null);
        }
        if(employee.getOrders() != null && !employee.getOrders().isEmpty()){
            for (Order order:employee.getOrders()){
                employee.removeOrder(order);
            }

        }
        userRepository.delete(empId);
    }

    //More if needed
}
