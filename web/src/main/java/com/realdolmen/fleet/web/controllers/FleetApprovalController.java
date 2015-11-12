package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.model.domain.Order;
import com.realdolmen.fleet.model.domain.Status;
import com.realdolmen.fleet.repositories.repository.OrderRepository;
import com.realdolmen.fleet.services.MailService;
import com.realdolmen.fleet.services.OrderService;
import com.realdolmen.fleet.web.Factory.MailFactory;
import com.realdolmen.fleet.web.viewmodels.CreateOrderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by SDOAX36 on 12/11/2015.
 */

@Controller
public class FleetApprovalController {

    @Autowired
    OrderService orderService;

    @Autowired
    MailService mailService;


    @RequestMapping(value = "/fleet/orders/{id}/approve", method = RequestMethod.GET)
    public String orderToApprove(@PathVariable("id") Integer id, Model model) {
        Order order = orderService.getOrderForId(id);
        model.addAttribute("title", "Approve order");
        CreateOrderViewModel orderVM = new CreateOrderViewModel(order.getEmployee(), order);
        orderVM.setTitleMail(MailFactory.CAR_ORDER_APPROVED);
        orderVM.setMailText(MailFactory.createCarOrderApprovedMail(order.getEmployee().getFirstName(), order.getOrderCode(), ""));
        model.addAttribute("createOrderViewModel", orderVM);
        model.addAttribute("url", "/fleet/orders/" + order.getId() + "/approved");

        return "/fleet/approveorder";
    }

    @RequestMapping(value = "/fleet/orders/{id}/disapprove", method = RequestMethod.GET)
    public String orderToDisapprove(@PathVariable("id") Integer id, Model model) {
        Order order = orderService.getOrderForId(id);
        model.addAttribute("title", "Deny order");
        CreateOrderViewModel orderVM = new CreateOrderViewModel(order.getEmployee(), order);
        orderVM.setTitleMail(MailFactory.CAR_ORDER_DENIED);
        orderVM.setMailText(MailFactory.createCarOrderDeniedMail(order.getEmployee().getFirstName(), order.getOrderCode(), ""));
        model.addAttribute("createOrderViewModel", orderVM);
        model.addAttribute("url", "/fleet/orders/" + order.getId() + "/disapproved");
        return "/fleet/approveorder";
    }

    @RequestMapping(value = "/fleet/orders/{id}/approved", method = RequestMethod.POST)
    public RedirectView orderApproved(@PathVariable("id") Integer id, @ModelAttribute CreateOrderViewModel createOrderViewModel, RedirectAttributes attr, @RequestParam(value = "action", required = true) String action) {


        if (action.equals("save")) {
            Order order = orderService.approveOrder(id);
            System.out.println("Comment " + createOrderViewModel.getComment());
            String title = MailFactory.CAR_ORDER_APPROVED;
            String mailText = MailFactory.createCarOrderApprovedMail(order.getEmployee().getFirstName(), order.getOrderCode(), createOrderViewModel.getComment());
            mailService.sendMail(order.getEmployee().getEmail(), title, mailText);
            attr.addFlashAttribute("success", "An e-mail was send to " + order.getEmployee().getUsername() + " to approve his order " + order.getOrderCode());

        }
        else
        {
            attr.addFlashAttribute("warning","The order was cancelled!!");
        }


//set message for Employee
        return new RedirectView("/fleet/ordercontrol");

    }

    @RequestMapping(value = "/fleet/orders/{id}/disapproved", method = RequestMethod.POST)
    public RedirectView orderDisApproved(@PathVariable("id") Integer id, @ModelAttribute CreateOrderViewModel createOrderViewModel, RedirectAttributes attr, @RequestParam(value = "action", required = true) String action) {

        if(action.equals("save"))
        {
            Order order = orderService.deniedOrder(id, createOrderViewModel.getComment());

            String title = MailFactory.CAR_ORDER_DENIED;
            String mailText = MailFactory.createCarOrderDeniedMail(order.getEmployee().getFirstName(), order.getOrderCode(), createOrderViewModel.getComment());
//set message for Employee
            System.out.println("Comment " + createOrderViewModel.getComment());
            mailService.sendMail(order.getEmployee().getEmail(), title, mailText);
            attr.addFlashAttribute("success", "An e-mail was send to " + order.getEmployee().getUsername() + " to disapprove his order " + order.getOrderCode());

        }
        else
        {
            attr.addFlashAttribute("warning","The order was cancelled!!");
        }
        return new RedirectView("/fleet/ordercontrol");

    }


}
