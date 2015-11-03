package com.realdolmen.fleet.services;

import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.repositories.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return (List<Employee>)(List<?>)userRepository.findAll();
    }

    public Employee findEmployeeById(Integer id)throws Exception
    {
        return (Employee)userRepository.findOne(id);
    }


    //More if needed
}
