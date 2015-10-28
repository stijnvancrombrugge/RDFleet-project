package com.realdolmen.fleet.model.domain;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by SVCAX33 on 28/10/2015.
 */

@Entity
public class Order extends AbstractEntity {

    @Basic(optional = false)
    private int price;

    @Basic(optional = false)
    @Column(unique = true)
    private String orderCode;

    @Basic(optional = false)
    private Car car;

    @Basic(optional = false)
    private boolean currentCar;

    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private LocalDate orderDate;



    public Order(int price, String orderCode, Car car, boolean currentCar, LocalDate orderDate) {
        this.price = price;
        this.orderCode = orderCode;
        this.car = car;
        this.currentCar = currentCar;
        this.orderDate = orderDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isCurrentCar() {
        return currentCar;
    }

    public void setCurrentCar(boolean currentCar) {
        this.currentCar = currentCar;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
