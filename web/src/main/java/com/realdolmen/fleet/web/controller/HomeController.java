package com.realdolmen.fleet.web.controller;

import com.realdolmen.fleet.model.domain.User;
import com.realdolmen.fleet.repositories.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.security.RolesAllowed;

/**
 * Created by SVCAX33 on 28/10/2015.
 */
@Controller
public class HomeController {

    private UserRepository userRepository;
    @Autowired
    public HomeController(UserRepository userRepository) { // inject repository
        this.userRepository = userRepository;
    }

    @RequestMapping(value = {"/", "/index", "/home"}, method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error() {
        return "404";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUserRedirect(User user) {
        userRepository.save(user);

        System.out.println(user.getFirstName());
        if (user.getRole().equals("ROLE_USER")){
            return "employee/home";
        }
        else if(user.getRole().equals("ROLE_ADMIN"))
        {
            return "fleet/home";
        }
        return "index";
    }

}