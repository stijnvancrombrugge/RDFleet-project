package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.domain.Order;
import com.realdolmen.fleet.services.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDOAX36 on 3/11/2015.
 */
public class FleetHomeModel {


    private int totalFleetCars;
    private int totalFreeFleetCars;
    private int totalActiveCars;

    private int totalOrders;
    private List<FleetHomeOrderModel>orders;

    public FleetHomeModel(int totalFleetCars,int totalFreeFleetCars,int totalActiveCars,List<Order>orders)
    {
        this.totalActiveCars = totalActiveCars;
        this.totalFleetCars = totalFleetCars;
        this.totalFreeFleetCars = totalFreeFleetCars;

        createOrders(orders);
        this.totalOrders = orders.size();
    }

    public int getTotalFleetCars() {
        return totalFleetCars;
    }

    public void setTotalFleetCars(int totalFleetCars) {
        this.totalFleetCars = totalFleetCars;
    }

    public int getTotalFreeFleetCars() {
        return totalFreeFleetCars;
    }

    public void setTotalFreeFleetCars(int totalFreeFleetCars) {
        this.totalFreeFleetCars = totalFreeFleetCars;
    }

    public int getTotalActiveCars() {
        return totalActiveCars;
    }

    public void setTotalActiveCars(int totalActiveCars) {
        this.totalActiveCars = totalActiveCars;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public List<FleetHomeOrderModel> getOrders() {
        return orders;
    }

    public void createOrders(List<Order> orders1) {
        if(this.orders == null)
        {
            this.orders = new ArrayList<>();
        }
        for(Order o : orders1)
        {
            this.orders.add(new FleetHomeOrderModel(o));
        }
    }

    public void setOrders(List<FleetHomeOrderModel> orders) {
        this.orders = orders;
    }

    class FleetHomeOrderModel{

        private String userName;
        private int orderId;
        private String carModelMark;
        private String date;
        private String orderCode;
        private String status;


        public FleetHomeOrderModel(Order order)
        {
            this.userName = order.getEmployee().getFirstName()+" "+order.getEmployee().getLastName();
            this.orderId = order.getId();
            if(order.getCar()!=null)
            {
                this.carModelMark = order.getCar().getCarModel().getMark()+" "+order.getCar().getCarModel().getModel();

            }
            else
            {
                this.carModelMark = "No car in this order";
            }

            this.date = DateUtil.dateToString(order.getOrderDate(),DateUtil.DAY_MONTH_YEAR);
            this.orderCode = order.getOrderCode();
            this.status = order.getStatus().toString();

        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public String getCarModelMark() {
            return carModelMark;
        }

        public void setCarModelMark(String carModelMark) {
            this.carModelMark = carModelMark;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getOrderCode() {
            return orderCode;
        }

        public void setOrderCode(String orderCode) {
            this.orderCode = orderCode;
        }
    }
}


