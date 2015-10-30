package com.realdolmen.fleet.model.domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by SVCAX33 on 28/10/2015.
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User extends AbstractEntity{

    @Size(min = 1, max = 50)
    private String firstName;

    @Size(min = 1, max = 200)
    private String lastName;

    @Size(min = 1, max = 100)
    @Basic(optional = false)
    @Column(unique = true)
    private String username;

    @Size(min=1, max = 50)
    @Basic(optional = false)
    private String password;

    @Basic(optional = false)
    @Email
    private String email;

    @Basic(optional = false)
    private String role;

    private String businessUnit;

    private int phoneNumber;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    public User(String username, String password, String email, Date birthDate, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.role = role;
    }

    protected User(){}

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
