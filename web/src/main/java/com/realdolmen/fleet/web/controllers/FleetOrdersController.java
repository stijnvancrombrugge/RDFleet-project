package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.model.domain.Status;
import com.realdolmen.fleet.services.FleetManagerService;
import com.realdolmen.fleet.services.OrderService;
import com.realdolmen.fleet.web.viewmodels.OrderControlModelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by SDOAX36 on 9/11/2015.
 */
@Controller
public class FleetOrdersController {


    @Autowired
    OrderService orderService;
    @Autowired
    FleetManagerService managerService;

    @RequestMapping(value = "/fleet/ordercontrol",method = RequestMethod.GET)
    public String orderControl(Model model, HttpSession session) throws Exception {
        int pending = orderService.getSizeOfListByStatus(Status.PENDING);
        int autoChoosen = orderService.getSizeOfListByStatus(Status.CAR_CHOSEN);
        int approved = orderService.getSizeOfListByStatus(Status.APPROVED);
        int denied = orderService.getSizeOfListByStatus(Status.DENIED);

        OrderControlModelView ocmv = new OrderControlModelView(pending,autoChoosen,approved,denied);
        ocmv.fillList(orderService.getAllOrdersByStatus(Status.PENDING),ocmv.getOrdersCarChosen());
        ocmv.fillList(orderService.getAllOrdersByStatus(Status.PENDING),ocmv.getOrdersApproved());
        ocmv.fillList(orderService.getAllOrdersByStatus(Status.PENDING),ocmv.getOrdersCarChosen());
        try {

            model.addAttribute("model",ocmv);

            return "/fleet/ordercontrol";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }
}
