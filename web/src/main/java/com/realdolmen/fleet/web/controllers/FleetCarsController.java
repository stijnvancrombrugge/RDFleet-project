package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.services.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by SVCAX33 on 11/11/2015.
 */

@Controller
public class FleetCarsController {

    @Autowired
    private CarModelService carModelService;

    @RequestMapping(value="/fleet/cars", method = RequestMethod.GET)
    public String fleetCars(Model model){
        model.addAttribute(carModelService.findAll());
        return "fleet/fleetcars";
    }

    @RequestMapping(value="/fleet/changeCarModelCategory/{carModelId}/{newCategory}", method = RequestMethod.GET)
    @ResponseBody
    public void removeEmployee(@PathVariable("carModelId") int carModelId, @PathVariable("newCategory") int newCategory) throws Exception {
        carModelService.changeCarModelCategory(carModelId, newCategory);
    }
}
