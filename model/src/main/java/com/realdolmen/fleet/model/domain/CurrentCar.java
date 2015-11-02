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
    @OneToOne(cascade = CascadeType.PERSIST)
    private Car car;

    public CurrentCar(Car car){
        this.car = car;
        this.leasingStartDate = new Date();
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
}
