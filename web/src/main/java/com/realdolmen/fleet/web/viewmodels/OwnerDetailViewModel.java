package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.domain.Employee;

/**
 * Created by SDOAX36 on 5/11/2015.
 */

public class OwnerDetailViewModel{


    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String business;
    private String klasse;
    private Integer id;


    public OwnerDetailViewModel(Employee e)
    {
        userName = e.getUsername();
        email = e.getEmail();
        firstName = e.getFirstName();
        lastName = e.getLastName();
        business = e.getBusinessUnit();
        klasse = "Category "+e.getCategory().getCategoryClass();
        id = e.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }
}
