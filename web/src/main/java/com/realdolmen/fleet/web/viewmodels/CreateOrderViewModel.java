package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.model.domain.Order;
import com.realdolmen.fleet.web.Factory.MailFactory;

/**
 * Created by SDOAX36 on 9/11/2015.
 */
public class CreateOrderViewModel {



    private String titleMail;
    private String mailText;
    private String comment;
    private String orderId;
    private String orderDate;


    private String firstName;
    private String lastName;
    private String email;
    private Integer employeeId;

    public CreateOrderViewModel(Employee e) {
        titleMail = MailFactory.CAR_ORDER;
        mailText = MailFactory.createCarOrderMail(e.getFirstName(),"","");
        firstName = e.getFirstName();
        lastName = e.getLastName();
        email = e.getEmail();
        employeeId = e.getId();

    }

    public CreateOrderViewModel()
    {

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }


    public String getTitleMail() {
        return titleMail;
    }

    public void setTitleMail(String titleMail) {
        this.titleMail = titleMail;
    }

    public String getMailText() {
        return mailText;
    }

    public void setMailText(String mailText) {
        this.mailText = mailText;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
