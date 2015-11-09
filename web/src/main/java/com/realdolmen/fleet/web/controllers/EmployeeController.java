package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.model.domain.Option;
import com.realdolmen.fleet.services.CarModelService;
import com.realdolmen.fleet.services.EmployeeService;
import com.realdolmen.fleet.services.OptionService;
import com.realdolmen.fleet.services.OrderService;
import com.realdolmen.fleet.web.viewmodels.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SVCAX33 on 2/11/2015.
 */

@Controller
public class EmployeeController {

    //private UserRepository userRepository;
    private EmployeeService employeeService;
    private CarModelService carModelService;
    private OptionService optionService;
    private OrderService orderService;


    @Autowired
    public EmployeeController(EmployeeService service, CarModelService carModelService, OptionService optionService, OrderService orderService){
        this.employeeService = service;
        this.carModelService = carModelService;
        this.optionService = optionService;
        this.orderService = orderService;
    }

    @ModelAttribute("employeePageViewModel")
    public EmployeePageViewModel addEmployeePageViewModel(HttpSession httpSession)
    {
        Employee employee = null;
        try {
            employee = employeeService.findEmployeeById((int)httpSession.getAttribute("id"));
            return (new EmployeePageViewModel(employee));
        } catch (Exception e) {
            System.out.println("Something when't terrible wrong "+e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = {"/employee/home","/employee","/employee/index"}, method = RequestMethod.GET)
    public String home(){ return "/employee/home";}


    @RequestMapping(value= "/employee/order", method = RequestMethod.GET)
    public String checkorder(Model model){
        model.addAttribute(new CarModelFilterViewModel());
        return "/employee/order";
    }


    @RequestMapping(value="/employee/checkOrderCode/{code}", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkOrderCode(@PathVariable("code") String code){
        return true;
    }

    @RequestMapping(value= "/employee/order", method = RequestMethod.POST)
    public String startOrder(@Valid CarModelFilterViewModel carModelFilterViewModel, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "redirect:/employee/order?error";
        }
        return "redirect:/employee/" + carModelFilterViewModel.getCategory() + "/" + carModelFilterViewModel.getMark();
    }

    @RequestMapping(value="/employee/{category}/{mark}", method = RequestMethod.GET)
    public String model(@PathVariable("category") int category, @PathVariable("mark") String mark, Model model) throws Exception {
        List<CarModel> carModels = carModelService.findByMarkAndCategory(mark, category);
        model.addAttribute(carModels);
        return "/employee/model";
    }

    @RequestMapping(value="/employee/details/{modelId}", method = RequestMethod.GET)
    public String modelDetails(@PathVariable("modelId") int modelId, Model model){
        CarModel carModel = carModelService.findById(modelId);
        model.addAttribute(carModel);
        List<Option> optionList = optionService.getAllOptions();
        model.addAttribute(optionList);
        model.addAttribute(new CarOrderViewModel());
        return "employee/details";
    }


    @RequestMapping(value = "/employee/details", method= RequestMethod.POST)
    public String processForm(@Valid CarOrderViewModel carOrderViewModel, BindingResult bindingResult, Model model, HttpSession session) throws Exception {
        int id = (int)session.getAttribute("id");
        if (bindingResult.hasErrors()) {
            return "redirect:/employee/details/" + carOrderViewModel.getCarModelId() +"?error";
        }

        List<Option> optionList =  new ArrayList<>();
        if(carOrderViewModel.getOptionList() != null) {
            for (int optionId : carOrderViewModel.getOptionList()) {
                optionList.add(optionService.getOptionForId(optionId));
            }
        }
        CarModel carModel = carModelService.findById(carOrderViewModel.getCarModelId());
        String color = carOrderViewModel.getColor();
        orderService.orderNewCar(optionList, carModel, color, employeeService.findEmployeeById(id));
        model.addAttribute(carModel);
        model.addAttribute(carOrderViewModel);
        model.addAttribute(optionList);
        return "/employee/confirmation";
    }




}
