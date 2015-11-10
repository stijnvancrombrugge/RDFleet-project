package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.model.domain.CurrentCar;
import com.realdolmen.fleet.services.CurrentCarService;
import com.realdolmen.fleet.services.FleetManagerService;
import com.realdolmen.fleet.services.OrderService;
import com.realdolmen.fleet.web.viewmodels.FleetPoolViewModel;
import com.realdolmen.fleet.web.viewmodels.FleetPoolViewModelList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SDOAX36 on 4/11/2015.
 */
@Controller
public class FleetPoolController {


    @Autowired
    CurrentCarService currentCarService;
    @Autowired
    OrderService orderService;
    @Autowired
    FleetManagerService fleetManagerService;

    @RequestMapping(value = "/fleet/control/freepool",method = RequestMethod.GET)
    public String freepool(Model model)
    {
        try {
            model.addAttribute("title","Free pool");
            model.addAttribute("active",false);
            model.addAttribute("modelList",new FleetPoolViewModelList(currentCarService.getAllFreeFleetCars()));
            return "/fleet/fleetpool";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping(value = "/fleet/control/activepool",method = RequestMethod.GET)
    public String activepool(Model model)
    {
        try {
            model.addAttribute("title","Active pool");
            model.addAttribute("active",true);
            model.addAttribute("modelList",new FleetPoolViewModelList(currentCarService.getAllActiveCurrentCars()));
            return "/fleet/fleetpool";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }




    @RequestMapping(value = "/fleet/control/currentcar/{modelId}",method = RequestMethod.GET)
    public String getCarDetails(@PathVariable("modelId")Integer modelId,Model model)
    {
        try {
            CurrentCar car = currentCarService.getCurrentCarById(modelId);
            if (car.getEmployee()==null)
            {
                model.addAttribute("active",false);
                model.addAttribute("title","Free pool");
            }
            else
            {
                model.addAttribute("active",true);
                model.addAttribute("title","Active pool");
            }
            model.addAttribute("model",new FleetPoolViewModel(car));
            return "/fleet/fleetdetails";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

}
