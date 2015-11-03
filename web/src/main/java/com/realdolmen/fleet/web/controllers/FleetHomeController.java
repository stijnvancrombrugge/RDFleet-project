package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.services.FleetManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SVCAX33 on 28/10/2015.
 */

@Controller
public class FleetHomeController {

    @Autowired
    FleetManagerService service;


    @RequestMapping(value= {"/fleet/{id}","/fleet/{id}/home"}, method = RequestMethod.GET)
    public String fleetHome(@PathVariable("id")Integer id,Model model)
    {

        try {
            model.addAttribute("fleetManager",service.findFleetManager(id));
            return "/fleet/index";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }

}
