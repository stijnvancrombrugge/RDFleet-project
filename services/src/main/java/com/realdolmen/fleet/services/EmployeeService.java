package com.realdolmen.fleet.services;

import com.realdolmen.fleet.model.domain.*;
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
        //think with me
       for(Employee e : employees)
       {
           //if employee has a car?? He can't get an order
           if(e.getCurrentCar() != null || e.getOrders().size()!=0)
           {
               //so we put him in the list to remove
               employeeListToRemove.add(e);
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

    public void createCurrentCarFromOrder(Employee employee, CurrentCar currentCar)
    {
        employee.setCurrentCar(currentCar);
        userRepository.saveAndFlush(employee);
    }

    //More if needed
}
