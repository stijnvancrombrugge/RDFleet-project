package com.realdolmen.fleet.web.validators;

import com.realdolmen.fleet.web.viewmodels.EmployeeCreationModel;
import org.springframework.boot.autoconfigure.data.jpa.EntityManagerFactoryDependsOnPostProcessor;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by SDOAX36 on 6/11/2015.
 */
public class EmailValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return EmployeeCreationModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        EmployeeCreationModel ecm = (EmployeeCreationModel) o;
        if (!ecm.geteMail().endsWith("realdolmen.com"))
        {
            errors.rejectValue("eMail","Not a RealDolmen e-mail address");
        }
    }
}
