package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.model.domain.CurrentCar;
import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.model.domain.Option;
import com.realdolmen.fleet.services.*;
import com.realdolmen.fleet.web.viewmodels.CarOrderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SVCAX33 on 5/11/2015.
 */

@Controller
public class CarOrderController {

    private CarModelService carModelService;
    private OptionService optionService;
    private OrderService orderService;
    private EmployeeService employeeService;
    @Autowired
    public CarOrderController(OrderService orderService, CarModelService carModelService, OptionService optionService, EmployeeService employeeService){
        this.orderService = orderService;
        this.optionService = optionService;
        this.carModelService = carModelService;
        this.employeeService = employeeService;

    }


    @RequestMapping(value = "/employee/{id}/carOrder", method= RequestMethod.POST)
    public String processForm(@Valid CarOrderViewModel carOrderViewModel, BindingResult bindingResult, @PathVariable("id") int id) throws Exception {
        if (bindingResult.hasErrors()) {
            return "redirect:/employee/" + id +"/details/" + carOrderViewModel.getCarModelId() +"?error";
        }

        List<Option> optionList =  new ArrayList<>();
        if(!optionList.isEmpty()) {
            for (int optionId : carOrderViewModel.getOptionList()) {
                optionList.add(optionService.getOptionForId(optionId));
            }
        }
        orderService.orderNewCar(optionList, carModelService.findById(carOrderViewModel.getCarModelId()), carOrderViewModel.getColor(), employeeService.findEmployeeById(id));
        return "redirect:/employee/" + id + "/home";
    }
}
