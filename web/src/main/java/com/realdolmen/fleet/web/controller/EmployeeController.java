package com.realdolmen.fleet.web.controller;

import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.model.domain.User;
import com.realdolmen.fleet.repositories.repository.UserRepository;
import com.realdolmen.fleet.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import javax.websocket.server.PathParam;

/**
 * Created by SVCAX33 on 2/11/2015.
 */

@Controller
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) { // inject repository
        this.service = service;
    }

    @RequestMapping(value = {"/employee/{id}", "/employee/{id}/index"}, method = RequestMethod.GET)
    public String profile(@PathVariable("id")Integer id,Model model){
        System.out.println("Id = " + id);
        try {
            model.addAttribute("employee",service.findEmployeeById(id));
            return "/employee/index";
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "error";
        }
    }


}
