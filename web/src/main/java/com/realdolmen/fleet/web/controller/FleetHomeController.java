package com.realdolmen.fleet.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SVCAX33 on 28/10/2015.
 */

@Controller
public class FleetHomeController {

    @RequestMapping(value= "/fleet/fleetHome", method = RequestMethod.GET)
    public String fleetHome(){
        System.out.println("Controlling");
        return "/fleet/fleetHome";
    }
}
