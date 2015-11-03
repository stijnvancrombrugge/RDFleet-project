package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.domain.Category;
import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.repositories.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by SVCAX33 on 2/11/2015.
 */


public class EmployeeViewModel {

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String businessUnit;
    private int phoneNumber;
    private String password;
    private String email;
    private Date birthDate;
    private String role;
    private Category category;


    public EmployeeViewModel(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.businessUnit = employee.getBusinessUnit();
        this.phoneNumber = employee.getPhoneNumber();
        this.username = employee.getUsername();
        this.password = employee.getPassword();
        this.email = employee.getEmail();
        this.birthDate = employee.getBirthDate();
        this.role = employee.getRole();
        this.category = employee.getCategory();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
