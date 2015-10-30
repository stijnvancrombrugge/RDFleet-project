package com.realdolmen.fleet.model.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by SVCAX33 on 28/10/2015.
 */

@Entity
public class Employee extends User{

    @Basic(optional = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Order> orders;

    public Employee(String username, String password, Date birthDate, String email, Category category) {
        super(username, password, email, birthDate, "Employee");
        this.category = category;
        orders = new ArrayList<>();
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


/*    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }*/

    public void addOrder(Order order)
    {
        orders.add(order);
    }
    public void removeOrder(Order order)
    {
        orders.remove(order);
    }

}
