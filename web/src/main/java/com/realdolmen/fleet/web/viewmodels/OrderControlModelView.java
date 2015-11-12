package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.domain.Order;
import com.realdolmen.fleet.services.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDOAX36 on 9/11/2015.
 */
public class OrderControlModelView {

   private int totalPending, totalToApprove, totalApproved,totalDisapproved;
    private List<OrderControlList> ordersCarChosen;
    private List<OrderControlList> ordersApproved;
    private List<OrderControlList> ordersDenied;

    public OrderControlModelView(int totalPending, int totalToApprove, int totalApproved, int totalDisapproved) {
        this.totalPending = totalPending;
        this.totalToApprove = totalToApprove;
        this.totalApproved = totalApproved;
        this.totalDisapproved = totalDisapproved;
        ordersCarChosen = new ArrayList<>();
        ordersApproved = new ArrayList<>();
        ordersDenied = new ArrayList<>();
    }

    public void fillList(List<Order>o,List<OrderControlList>orders)
    {
        if(orders == null)
        {
            orders = new ArrayList<>();
        }
        for (Order or : o)
        {
            orders.add(new OrderControlList(or));
        }
    }

    public int getTotalPending() {
        return totalPending;
    }

    public void setTotalPending(int totalPending) {
        this.totalPending = totalPending;
    }

    public int getTotalToApprove() {
        return totalToApprove;
    }

    public void setTotalToApprove(int totalToApprove) {
        this.totalToApprove = totalToApprove;
    }

    public int getTotalApproved() {
        return totalApproved;
    }

    public void setTotalApproved(int totalApproved) {
        this.totalApproved = totalApproved;
    }

    public int getTotalDisapproved() {
        return totalDisapproved;
    }

    public void setTotalDisapproved(int totalDisapproved) {
        this.totalDisapproved = totalDisapproved;
    }

    public List<OrderControlList> getOrdersCarChosen() {
        return ordersCarChosen;
    }

    public void setOrdersCarChosen(List<OrderControlList> ordersCarChosen) {
        this.ordersCarChosen = ordersCarChosen;
    }

    public List<OrderControlList> getOrdersApproved() {
        return ordersApproved;
    }

    public void setOrdersApproved(List<OrderControlList> ordersApproved) {
        this.ordersApproved = ordersApproved;
    }

    public List<OrderControlList> getOrdersDenied() {
        return ordersDenied;
    }

    public void setOrdersDenied(List<OrderControlList> ordersDenied) {
        this.ordersDenied = ordersDenied;
    }

    public class OrderControlList{
        private String orderCode;
        private String userName;
        private String appDate;
        private Integer id;

        public OrderControlList(Order o) {
            this.orderCode = o.getOrderCode();
            this.userName = o.getEmployee().getUsername();
            this.id = o.getId();
            if(o.getManagerGoedDate()!=null)
            {
                this.appDate = DateUtil.dateToString(o.getManagerGoedDate(),DateUtil.DAY_MONTH_YEAR);
            }
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getOrderCode() {
            return orderCode;
        }

        public void setOrderCode(String orderCode) {
            this.orderCode = orderCode;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getAppDate() {
            return appDate;
        }

        public void setAppDate(String appDate) {
            this.appDate = appDate;
        }
    }
}
