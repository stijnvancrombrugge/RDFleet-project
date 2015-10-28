package com.realdolmen.fleet.model.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by SVCAX33 on 28/10/2015.
 */

@Entity
public class Employee extends User{

    @Basic(optional = false)
    private Category category;

    private List<Order> orders;

    public Employee(String username, String password, LocalDate birthDate, String email, Category category) {
        super(username, password, email, birthDate, "Employee");
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
