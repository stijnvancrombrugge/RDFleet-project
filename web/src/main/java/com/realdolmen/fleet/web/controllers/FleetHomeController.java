package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.services.CurrentCarService;
import com.realdolmen.fleet.services.FleetManagerService;
import com.realdolmen.fleet.services.OrderService;
import com.realdolmen.fleet.web.viewmodels.FleetHomeModel;
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
    FleetManagerService fleetManagerService;

    @Autowired
    OrderService orderService;

    @Autowired
    CurrentCarService currentCarService;


    @RequestMapping(value= {"/fleet/{id}","/fleet/{id}/home"}, method = RequestMethod.GET)
    public String fleetHome(@PathVariable("id")Integer id,Model model)
    {


        try {
            model.addAttribute("fleetManager",fleetManagerService.findFleetManager(id));
            FleetHomeModel homeModel = new FleetHomeModel(currentCarService.getCountAllCurrentCars(),
                    currentCarService.getFreeFleetCount(),
                    currentCarService.getActiveFleetCount(),
                    orderService.getAllOrders());
            model.addAttribute("fleetModel",homeModel);
            return "/fleet/index";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }

    @RequestMapping(value = "/fleet/{id}/control",method = RequestMethod.GET)
    public String fleetControl(@PathVariable("id")Integer id, Model model)
    {
        try
        {
            model.addAttribute("fleetManager",fleetManagerService.findFleetManager(id));
            //Another model should come here
            return "/fleet/control";
        }
        catch (Exception e)
        {
            return "error";
        }
    }


}
