package com.realdolmen.fleet.services;

import com.realdolmen.fleet.model.domain.Employee;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
/**
 * Created by SDOAX36 on 2/11/2015.
 */
public class EmployeeServiceTest extends AbstractServiceTest {

    @Test
    public void shouldReturnListEmployees()
    {
        List<Employee> employees = getEmployeeService().findAllEmployees();
        verify(getUserRepository()).findAll();
    }

    @Test
    public void shouldReturnOneEmployee()throws Exception
    {
        Employee employee = getEmployeeService().findEmployeeById(1);
        verify(getUserRepository()).findOne(1);
    }

    //more tests needed
}
