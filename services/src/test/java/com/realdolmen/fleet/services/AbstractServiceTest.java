package com.realdolmen.fleet.services;


import com.realdolmen.fleet.repositories.repository.UserRepository;
import config.TestConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by SDOAX36 on 2/11/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
public class AbstractServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Mock
    UserRepository userRepository;

    @Before
    public void setUp()throws Exception
    {
        MockitoAnnotations.initMocks(this);
        employeeService.userRepository = userRepository;


    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }


}
