package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.model.domain.Category;
import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.repositories.repository.*;
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


    private UserRepository userRepository;
    @Autowired
    public EmployeeController(UserRepository userRepository, OrderRepository orderRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/employee/{id}/home", method = RequestMethod.GET)
    public String home(@PathVariable("id") int id, Model model){
        Employee employee = (Employee)(userRepository.findOne(id));
        model.addAttribute(new EmployeeViewModel(employee));

        if (employee.getCurrentCar() != null) {

            CarViewModel carViewModel = new CarViewModel(employee.getCurrentCar().getCar());
            CarModelViewModel carModelViewModel = new CarModelViewModel(carViewModel.getCarModel());
            List<OptionPackViewModel> optionPackViewModelList = carViewModel.getOptionPackViewModelList();
            model.addAttribute(carViewModel);
            model.addAttribute(carModelViewModel);
            model.addAttribute(optionPackViewModelList);
        }
        return "/employee/home";
    }


}
