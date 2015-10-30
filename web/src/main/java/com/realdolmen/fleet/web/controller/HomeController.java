package com.realdolmen.fleet.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SVCAX33 on 28/10/2015.
 */
@Controller
public class HomeController {

    @RequestMapping(value={"/", "/index" ,"/home"}, method = RequestMethod.GET)
    public String home() {
        return "index";
    }
}