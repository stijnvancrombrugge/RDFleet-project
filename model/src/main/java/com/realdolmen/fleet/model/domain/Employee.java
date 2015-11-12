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

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "employee")
    private List<Order> orders;

    @OneToOne
    private CurrentCar currentCar;

    @OneToMany(mappedBy = "employee")
    private List<Message>messages;


    public Employee(String username, String password, Date birthDate, String email, Category category) {
        super(username, password, email, birthDate, "ROLE_USER");
        this.category = category;
        orders = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public Employee(String username,String password, String email, Category category, String first,String last)
    {
        super( username, password,email,"ROLE_USER");
        this.category = category;
        this.setFirstName(first);
        this.setLastName(last);
        this.messages = new ArrayList<>();

    }

    protected Employee(){}

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

    public CurrentCar getCurrentCar() {
        return currentCar;
    }

    public void setCurrentCar(CurrentCar currentCar) {
        this.currentCar = currentCar;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addMessage(Message message)
    {
        this.messages.add(message);
    }
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
