package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.domain.Order;
import com.realdolmen.fleet.services.util.DateUtil;

/**
 * Created by SDOAX36 on 10/11/2015.
 */
public class OrderDetailsViewModel {

    private String orderCode;
    private String orderDate;
    private String orderStatus;
    private boolean upgrade;
    private boolean downgrade;

    public OrderDetailsViewModel(Order order) {
        orderCode = order.getOrderCode();
        orderDate = DateUtil.dateToString(order.getOrderDate(),DateUtil.DAY_MONTH_YEAR);

    }
}
