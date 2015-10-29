package com.realdolmen.fleet.model.domain;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SVCAX33 on 28/10/2015.
 */

@Entity
public class Category extends AbstractEntity {

    @Basic(optional = false)
    private int categoryClass;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Car> cars;


    public Category(int categoryClass) {
        this.categoryClass = categoryClass;
        this.cars = new ArrayList<>();
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

    /*public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    */

    public void addCar(Car car)
    {
        cars.add(car);
    }
    public void removeCar(Car car)
    {
        cars.remove(car);
    }


}
