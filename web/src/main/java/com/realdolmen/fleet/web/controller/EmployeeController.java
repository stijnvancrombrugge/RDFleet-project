package com.realdolmen.fleet.web.controller;

import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.model.domain.User;
import com.realdolmen.fleet.repositories.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SVCAX33 on 2/11/2015.
 */

@Controller
public class EmployeeController {

    private UserRepository userRepository;
    @Autowired
    public EmployeeController(UserRepository userRepository) { // inject repository
        this.userRepository = userRepository;
    }

    @RequestMapping(value = {"/employee/home", "/employee/index"}, method = RequestMethod.GET)
    public Employee profile(){
        return (Employee)userRepository.findByUsername("stijn").get();
    }


}
