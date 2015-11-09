package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.model.domain.FleetManager;
import com.realdolmen.fleet.services.EmployeeService;
import com.realdolmen.fleet.services.FleetManagerService;
import com.realdolmen.fleet.services.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by SVCAX33 on 28/10/2015.
 */
@Controller
public class HomeController {


    @Autowired
    UserDetailService userDetailService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    FleetManagerService fleetManagerService;


    @RequestMapping(value = {"/", "/index", "/home", "/login"}, method = RequestMethod.GET)
    public String login() {

        return "login";
    }


    

}