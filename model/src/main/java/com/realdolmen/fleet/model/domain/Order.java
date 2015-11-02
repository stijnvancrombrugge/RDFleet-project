package com.realdolmen.fleet.model.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by SVCAX33 on 28/10/2015.
 */

@Entity
@Table(name = "Orders")
public class Order extends AbstractEntity {


    //@NotNull
    @Column(unique = true)
    //@GeneratedValue(strategy = )
    private String orderCode;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Car car;


    @NotNull
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    public Order() {
        orderDate = new Date();
    }

    public Order( Car car) {

        this.car = car;
        this.orderDate = new Date();
    }

    public String getOrderCode() {
        return orderCode;
    }

    private void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @PostPersist
    private void generateCode()
    {
        setOrderCode(getId()+"ORDER"+car.getId()+car.getCarModel().getModel());
    }
}
