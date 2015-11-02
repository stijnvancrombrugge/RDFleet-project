package com.realdolmen.fleet.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SVCAX33 on 2/11/2015.
 */

@Controller
public class EmployeeController {

    @RequestMapping(value = "/employee/home", method = RequestMethod.GET)
    public String home(){
        return "/employee/index";
    }

    @RequestMapping(value = "/employee/profile", method = RequestMethod.GET)
    public String profile(){
        return "/employee/profile";
    }
}
