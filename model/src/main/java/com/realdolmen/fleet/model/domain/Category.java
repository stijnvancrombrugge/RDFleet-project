package com.realdolmen.fleet.model.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import java.util.List;

/**
 * Created by SVCAX33 on 28/10/2015.
 */

@Entity
public class Category extends AbstractEntity {

    @Basic(optional = false)
    private int categoryClass;

     private List<Car> cars;


    public Category(int categoryClass) {
        this.categoryClass = categoryClass;
    }

    public int getCategoryClass() {
        return categoryClass;
    }

    public void setCategoryClass(int categoryClass) {
        this.categoryClass = categoryClass;
    }



    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

}
