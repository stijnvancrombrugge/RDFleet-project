package com.realdolmen.fleet.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SVCAX33 on 28/10/2015.
 */
@Controller
public class HomeController {




    @RequestMapping(value = {"/", "/index", "/home", "/login"}, method = RequestMethod.GET)
    public String login() {

        return "login";
    }




}