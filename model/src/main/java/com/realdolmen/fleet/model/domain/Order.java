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


    @ManyToOne(cascade = CascadeType.PERSIST)
    private Car car;

    @NotNull
    @ManyToOne
    private Employee employee;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Temporal(TemporalType.DATE)
    private Date managerGoedDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String commentFromManager;

    public Order() {

        orderDate = new Date();
        status = Status.PENDING;
    }

    public Order( Car car) {

        this.car = car;
        this.orderDate = new Date();
        status = Status.PENDING;
    }

    public Order(Employee employee)
    {
        this.employee = employee;
        this.orderDate = new Date();
        this.status = Status.PENDING;
    }


    public String getCommentFromManager() {
        return commentFromManager;
    }

    public void setCommentFromManager(String commentFromManager) {
        this.commentFromManager = commentFromManager;
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

    public Date getManagerGoedDate() {
        return managerGoedDate;
    }

    public void setManagerGoedDate(Date managerGoedDate) {
        this.managerGoedDate = managerGoedDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @PostPersist
    private void generateCode()
    {

        setOrderCode(getId()+"ORDER"+getEmployee().getUsername());
    }
}
