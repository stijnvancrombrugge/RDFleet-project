package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.services.CurrentCarService;
import com.realdolmen.fleet.services.FleetManagerService;
import com.realdolmen.fleet.services.OrderService;
import com.realdolmen.fleet.web.viewmodels.FleetControlViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

/**
 * Created by SDOAX36 on 4/11/2015.
 */
@Controller
@RequestMapping(value = "/fleet/{id}/control")
public class FleetControlController {

    @Autowired
    FleetManagerService fleetManagerService;

    @Autowired
    OrderService orderService;

    @Autowired
    CurrentCarService currentCarService;

    @RequestMapping(method = RequestMethod.GET)
    public String fleetControl(@PathVariable("id")Integer id, Model model)
    {
        System.out.println("FleetControl request");
        try
        {
            model.addAttribute("fleetManager",fleetManagerService.findFleetManager(id));
            model.addAttribute("freepool",freepool());
            model.addAttribute("activepool",activepool());
            model.addAttribute("orders",orders());
            //Another model should come here
            return "/fleet/control";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "error";
        }
    }


    private FleetControlViewModel freepool()
    {
        int audi = currentCarService.getCountFromFreePoolByMark("Audi");
        int vw = currentCarService.getCountFromFreePoolByMark("Volkswagen");
        int skoda = currentCarService.getCountFromFreePoolByMark("Skoda");
        int seat = currentCarService.getCountFromActivePoolByMark("Seat");

        return new FleetControlViewModel(audi,skoda,vw,seat);
    }


    private FleetControlViewModel activepool()
    {
        int audi = currentCarService.getCountFromActivePoolByMark("Audi");
        int vw = currentCarService.getCountFromActivePoolByMark("Volkswagen");
        int skoda = currentCarService.getCountFromActivePoolByMark("Skoda");
        int seat = currentCarService.getCountFromActivePoolByMark("Seat");

        return new FleetControlViewModel(audi,skoda,vw,seat);
    }

    private FleetControlViewModel orders()
    {
        int audi = orderService.getAllOrdersForMarkCount("Audi");
        int vw = orderService.getAllOrdersForMarkCount("Volkswagen");
        int skoda = orderService.getAllOrdersForMarkCount("Skoda");
        int seat = orderService.getAllOrdersForMarkCount("Seat");

        return new FleetControlViewModel(audi,skoda,vw,seat);
    }
}
