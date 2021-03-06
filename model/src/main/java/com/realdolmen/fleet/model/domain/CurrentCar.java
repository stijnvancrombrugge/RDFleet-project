package com.realdolmen.fleet.model.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Date;

/**
 * Created by SVCAX33 on 2/11/2015.
 */

@Entity
public class CurrentCar extends AbstractEntity{

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date leasingStartDate;


    @NotNull
    @OneToOne
    private Car car;

    @OneToOne(mappedBy = "currentCar")
    private Employee employee;

    private boolean renewMailSend;

    public CurrentCar(Car car){
        this.car = car;
        this.leasingStartDate = new Date();
        this.renewMailSend = false;

    }

    protected CurrentCar(){}

    public Date getLeasingStartDate() {
        return leasingStartDate;
    }

    public void setLeasingStartDate(Date leasingStartDate) {
        this.leasingStartDate = leasingStartDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isRenewMailSend() {
        return renewMailSend;
    }

    public void setRenewMailSend(boolean renewMailSend) {
        this.renewMailSend = renewMailSend;
    }
}
