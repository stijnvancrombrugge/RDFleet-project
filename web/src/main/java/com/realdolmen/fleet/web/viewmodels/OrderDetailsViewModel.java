package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.domain.Order;
import com.realdolmen.fleet.services.util.DateUtil;

/**
 * Created by SDOAX36 on 10/11/2015.
 */
public class OrderDetailsViewModel {

    private String orderCode;
    private int orderId;
    private String orderDate;
    private String orderStatus;
    private boolean upgrade;
    private boolean downgrade;

    public OrderDetailsViewModel(Order order) {
        orderId = order.getId();
        orderCode = order.getOrderCode();
        orderDate = DateUtil.dateToString(order.getOrderDate(), DateUtil.DAY_MONTH_YEAR);
        orderStatus = order.getStatus().toString();
        if (order.getCar() != null) {
            upgrade = order.getCar().getCarModel().getCategory().getCategoryClass() > order.getEmployee().getCategory().getCategoryClass();
            downgrade = order.getCar().getCarModel().getCategory().getCategoryClass() < order.getEmployee().getCategory().getCategoryClass();
        }
        else
        {
            upgrade = downgrade = false;
        }


    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public boolean isUpgrade() {
        return upgrade;
    }

    public void setUpgrade(boolean upgrade) {
        this.upgrade = upgrade;
    }

    public boolean isDowngrade() {
        return downgrade;
    }

    public void setDowngrade(boolean downgrade) {
        this.downgrade = downgrade;
    }
}
