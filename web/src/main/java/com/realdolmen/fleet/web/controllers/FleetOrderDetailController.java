package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.model.domain.Order;
import com.realdolmen.fleet.services.OrderService;
import com.realdolmen.fleet.web.viewmodels.CarOrderDetailsViewModel;
import com.realdolmen.fleet.web.viewmodels.OrderDetailsViewModel;
import com.realdolmen.fleet.web.viewmodels.OwnerDetailViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SDOAX36 on 10/11/2015.
 */
@Controller
@RequestMapping(value = "/fleet/orders/{id}")
public class FleetOrderDetailController {


    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public String orderDetails(@PathVariable("id")Integer id,Model model)
    {

        try
        {
            Order order = orderService.getOrderForId(id);
            System.out.println("Order is null??? "+(order == null));
            OrderDetailsViewModel odvm = new OrderDetailsViewModel(order);
            if(order.getCar()!=null)
            {
                CarOrderDetailsViewModel codvm = new CarOrderDetailsViewModel(order.getCar());
                model.addAttribute("carOrderDetails",codvm);
            }
            OwnerDetailViewModel own = new OwnerDetailViewModel(order.getEmployee());

            model.addAttribute("orderDetails",odvm);
            model.addAttribute("ownerDetails",own);

            return "/fleet/orderdetails";
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return "error";
        }

    }

}
