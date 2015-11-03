package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.model.domain.Category;
import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.repositories.repository.*;
import com.realdolmen.fleet.services.EmployeeService;
import com.realdolmen.fleet.services.UserDetailService;
import com.realdolmen.fleet.web.viewmodels.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by SVCAX33 on 2/11/2015.
 */

@Controller
public class EmployeeController {


    //private UserRepository userRepository;
    private EmployeeService service;


    @Autowired
    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @RequestMapping(value = {"/employee/{id}/home","/employee/{id}","/employee/{id}/index"}, method = RequestMethod.GET)
    public String home(@PathVariable("id") int id, Model model){
        Employee employee = null;
        try {
            employee = service.findEmployeeById(id);
            if (employee.getCurrentCar() != null) {

                CarViewModel carViewModel = new CarViewModel(employee.getCurrentCar().getCar());
                CarModelViewModel carModelViewModel = new CarModelViewModel(carViewModel.getCarModel());
                List<OptionPackViewModel> optionPackViewModelList = carViewModel.getOptionPackViewModelList();
                model.addAttribute(carViewModel);
                model.addAttribute(carModelViewModel);
                model.addAttribute(optionPackViewModelList);
            }
            model.addAttribute(new EmployeeViewModel(employee));
            return "/employee/home";
        } catch (Exception e) {
            System.out.println("Something when't terrible wrong "+e.getMessage());
            return "error";
        }
    }


}
