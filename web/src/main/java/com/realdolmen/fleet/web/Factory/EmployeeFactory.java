package com.realdolmen.fleet.web.Factory;

import com.realdolmen.fleet.model.domain.Category;
import com.realdolmen.fleet.model.domain.Employee;

import java.util.Date;
import java.util.Random;

/**
 * Created by SDOAX36 on 5/11/2015.
 */
public class EmployeeFactory {

    public static Employee ceateNewEmployee(String first,String last,Date gebDatum ,String email,Category category,String password)
    {
        Employee employee = new Employee(EmployeeFactory.usernameCreator(email),password,gebDatum,email,category);
        employee.setFirstName(first);
        employee.setLastName(last);
        return employee;
    }

    public static Employee createNewSimpleEmployee(String first,String last, String email, Category category, String password)
    {
        Employee employee = new Employee(usernameCreator(email),password,email,category,first,last);
        return employee;
    }


    public static String randomPaswordCreator(String firstName)
    {
        Random rand = new Random();
        return firstName.trim()+""+(1000+rand.nextInt(100000));
    }

    private static String usernameCreator(String email)
    {
        String[]splitted = email.split("@");
        return splitted[0];
    }
}

