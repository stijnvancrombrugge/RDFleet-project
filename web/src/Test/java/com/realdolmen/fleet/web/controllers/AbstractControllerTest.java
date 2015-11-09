package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.web.config.TestConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
/**
 * Created by SDOAX36 on 5/11/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
public abstract class AbstractControllerTest {

    protected MockMvc mvc;

    @Autowired
    protected WebApplicationContext context;




}
