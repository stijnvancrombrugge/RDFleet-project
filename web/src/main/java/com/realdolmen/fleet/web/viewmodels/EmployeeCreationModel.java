package com.realdolmen.fleet.web.viewmodels;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by SDOAX36 on 5/11/2015.
 */
public class EmployeeCreationModel {


    @NotNull(message = "First name can't be empty")
    @Size(min=2,max=100,message = "First name has to be between 2 and 100 digits")
    private String firstName;
    @NotNull(message = "Last name can't be empty")
    @Size(min=2,max=100,message = "Last name has to be between 2 and 100 digits")
    private String lastName;
    @Size(min=5,message = "E-mail can't be empty")
    @Email(message = "Enter a correct e-mail adres")
    @Qualifier("emailValidator")
    private String eMail;


    public EmployeeCreationModel() {
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
