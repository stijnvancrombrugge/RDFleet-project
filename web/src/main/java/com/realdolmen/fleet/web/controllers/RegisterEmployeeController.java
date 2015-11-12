package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.model.domain.Category;
import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.model.domain.FleetManager;
import com.realdolmen.fleet.security.config.Config.UserDetailService;
import com.realdolmen.fleet.services.CategoryService;
import com.realdolmen.fleet.services.EmployeeService;
import com.realdolmen.fleet.services.FleetManagerService;
import com.realdolmen.fleet.services.MailService;
import com.realdolmen.fleet.web.Factory.EmployeeFactory;
import com.realdolmen.fleet.web.viewmodels.EmployeeCreationModel;
import com.realdolmen.fleet.web.Factory.MailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by SDOAX36 on 5/11/2015.
 */
@Controller
@RequestMapping(value = "/fleet/register")
public class RegisterEmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    FleetManagerService fleetManagerService;

    @Autowired
    UserDetailService userDetailService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    MailService mailService;

    @Autowired
    Validator validator;

    @RequestMapping(method = RequestMethod.GET)
    public String register(Model model)
    {
        System.out.println("Register getter activated!!!");

        try {
            model.addAttribute("employeeCreationModel",new EmployeeCreationModel());
            return "/fleet/register";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveEmployeeAndSendMail(@ModelAttribute EmployeeCreationModel creationModel,BindingResult errors,Model model)
    {
        try {

            System.out.println("We are going to post");
            String password = EmployeeFactory.randomPaswordCreator(creationModel.getFirstName());

            String encodedPassword = userDetailService.encoder().encode(password);
            validator.validate(creationModel, errors);
            Category category = categoryService.findByCategoryClass(1);
            if( category == null){
                category = new Category(1);
            }
            Employee employee = EmployeeFactory.createNewSimpleEmployee(creationModel.getFirstName(), creationModel.getLastName(), creationModel.geteMail(), new Category(1), encodedPassword);
            if (employeeService.isEmployeePresent(employee.getUsername())) {
                errors.rejectValue("eMail", "errors.eMail", "User name is already in use!");
            }
            if (errors.hasErrors()) {
                System.out.println("Errors have been found");
                model.addAttribute("employeeCreationModel", creationModel);
                return "/fleet/register";
            }
            //save employee
            employeeService.saveEmployee(employee);
            //send mail
            mailService.sendMail(employee.getEmail(), MailFactory.USER_CREATION_SUBJECT, MailFactory.createUserMail(employee.getFirstName(), employee.getUsername(), password));
            //this should be another page but I still need to make it

            model.addAttribute("success","An e-mail has been sent to "+employee.getUsername());
            return "redirect:/fleet/home";
        }
        catch (Exception e) {
            e.printStackTrace();

            return "error";
        }
    }

}
