package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.model.domain.FleetManager;
import com.realdolmen.fleet.model.domain.Order;
import com.realdolmen.fleet.services.EmployeeService;
import com.realdolmen.fleet.services.FleetManagerService;
import com.realdolmen.fleet.services.MailService;
import com.realdolmen.fleet.services.OrderService;
import com.realdolmen.fleet.services.util.DateUtil;
import com.realdolmen.fleet.web.Factory.MailFactory;
import com.realdolmen.fleet.web.viewmodels.CreateOrderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SDOAX36 on 9/11/2015.
 */
@Controller
@RequestMapping(value = "/fleet/{id}/createOrder/{employeeId}")
public class CreateOrderController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    FleetManagerService fleetManagerService;

    @Autowired
    MailService mailService;

    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public String createOrder(@PathVariable("id") Integer id, @PathVariable("employeeId") Integer empId, Model model) {


        try {
            FleetManager fleetManager = fleetManagerService.findFleetManager(id);
            Employee employee = employeeService.findEmployeeById(empId);

                model.addAttribute("fleetManager",fleetManager );
                CreateOrderViewModel orderViewModel = new CreateOrderViewModel(employee);
                model.addAttribute("createOrderViewModel", orderViewModel);

                return "/fleet/orders";

        } catch (Exception e) {
            e.printStackTrace();

            return "error";
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public String postOrder(@PathVariable("id")Integer id,@PathVariable("employeeId")Integer empId,@ModelAttribute CreateOrderViewModel createOrderViewModel,Model model)
    {

        try {
            FleetManager fleetManager = fleetManagerService.findFleetManager(id);
            Employee employee = employeeService.findEmployeeById(empId);

            Order order = orderService.saveNewOrder(employee);


            String subj = MailFactory.CAR_ORDER;
            String mail = MailFactory.createCarOrderMail(employee.getFirstName(),order.getOrderCode(),createOrderViewModel.getComment());

            createOrderViewModel.setOrderId(order.getOrderCode());
            createOrderViewModel.setOrderDate(DateUtil.dateToString(order.getOrderDate(), DateUtil.DAY_MONTH_YEAR));
            createOrderViewModel.setMailText(mail);
            createOrderViewModel.setTitleMail(subj);
            createOrderViewModel.setEmail(employee.getEmail());
            mailService.sendMail(employee.getEmail(), subj, mail);

            model.addAttribute("fleetManager", fleetManager);
            model.addAttribute("createOrderViewModel",createOrderViewModel);
            model.addAttribute("success","An order was created for "+employee.getUsername());
            return "redirect:/fleet/"+fleetManager.getId()+"/home";
           // return "/fleet/ordersuccess";
        }
        catch (Exception e) {
        e.printStackTrace();
    }
        return "error";
    }
}
