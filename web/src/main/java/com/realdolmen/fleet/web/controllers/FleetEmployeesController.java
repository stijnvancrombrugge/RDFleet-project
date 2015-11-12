package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.services.*;
import com.realdolmen.fleet.web.viewmodels.EmployeeCarsViewModel;
import com.realdolmen.fleet.web.viewmodels.OwnerViewList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by SVCAX33 on 10/11/2015.
 */

@Controller
public class FleetEmployeesController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    OrderService orderService;

    @Autowired
    CurrentCarService currentCarService;

    @Autowired
    FleetManagerService fleetManagerService;

    @RequestMapping(value="/fleet/employees", method= RequestMethod.GET)
    public String employees(Model model, HttpSession session) throws Exception {
        model.addAttribute("fleetManager",fleetManagerService.findFleetManager((int)session.getAttribute("id")));
        model.addAttribute("employeeList",new OwnerViewList(employeeService.findAllEmployees()));
        return "/fleet/employees";
    }

    @RequestMapping(value="fleet/getCars/{ownerId}", method = RequestMethod.GET)
    public String employeeCars(Model model, HttpSession session, @PathVariable("ownerId") int ownerId) throws Exception {
        model.addAttribute("fleetManager",fleetManagerService.findFleetManager((int)session.getAttribute("id")));
        model.addAttribute(new EmployeeCarsViewModel(employeeService.findEmployeeById(ownerId)));
        return "fleet/employeecars";
    }


    @RequestMapping(value="/fleet/removeEmployee/{ownerId}", method = RequestMethod.GET)
    @ResponseBody
    public void removeEmployee(@PathVariable("ownerId") int ownerId, HttpSession session) throws Exception {
        employeeService.removeEmployeeById(ownerId);
    }

    @RequestMapping(value="/fleet/removeHistoryCar/{carId}/{employeeId}", method = RequestMethod.GET)
    @ResponseBody
    public void removeHistoryCar(@PathVariable("carId") int carId, @PathVariable("employeeId") int employeeId, HttpSession session) throws Exception {
        orderService.removeOrder(carId, employeeId);
    }

    @RequestMapping(value="/fleet/removeCurrentCar/{employeeId}", method = RequestMethod.GET)
    @ResponseBody
    public void removeCurrentCar( @PathVariable("employeeId") int employeeId, HttpSession session) throws Exception {
        employeeService.removeCurrentCarForEmployee(employeeId);
    }

}
