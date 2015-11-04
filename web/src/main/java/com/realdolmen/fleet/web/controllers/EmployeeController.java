package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.services.CarModelService;
import com.realdolmen.fleet.services.EmployeeService;
import com.realdolmen.fleet.web.viewmodels.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;

/**
 * Created by SVCAX33 on 2/11/2015.
 */

@Controller
public class EmployeeController {

    //private UserRepository userRepository;
    private EmployeeService employeeService;
    private CarModelService carModelService;


    @Autowired
    public EmployeeController(EmployeeService service, CarModelService carModelService){
        this.employeeService = service;
        this.carModelService = carModelService;
    }

    @ModelAttribute("employeePageViewModel")
    public EmployeePageViewModel addEmployeePageViewModel(@PathVariable("id") int id)
    {
        Employee employee = null;
        try {
            employee = employeeService.findEmployeeById(id);
            System.out.println(employee);
            return (new EmployeePageViewModel(employee));
        } catch (Exception e) {
            System.out.println("Something when't terrible wrong "+e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = {"/employee/{id}/home","/employee/{id}","/employee/{id}/index"}, method = RequestMethod.GET)
    public String home(){
        return "/employee/home";
    }


    @RequestMapping(value= "/employee/{id}/mark", method = RequestMethod.GET)
    public String mark(){
       return "/employee/mark";
    }

    @RequestMapping(value="/employee/{id}/{category}/{mark}", method = RequestMethod.GET)
    public String order(@PathVariable("category") int category, @PathVariable("mark") String mark, Model model) throws Exception {
        List<CarModel> carModels = carModelService.findByMarkAndCategory(mark, category);
        model.addAttribute(carModels);
        return "/employee/model";
    }

    @RequestMapping(value="/employee/{id}/details/{modelId}", method = RequestMethod.GET)
    public String modelDetails(@PathVariable("modelId") int modelId, Model model){
        CarModel carModel = carModelService.findById(modelId);
        model.addAttribute(carModel);
        return "employee/details";
    }

}
