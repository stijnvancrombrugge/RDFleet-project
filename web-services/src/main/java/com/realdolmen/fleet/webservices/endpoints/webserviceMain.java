package com.realdolmen.fleet.webservices.endpoints;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by SDOAX36 on 10/11/2015.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.realdolmen.fleet")
public class webserviceMain {

    public static void main(String[]args)
    {
        new SpringApplicationBuilder(webserviceMain.class).profiles("production").run();
       // SpringApplication.run(webserviceMain.class, args);
    }
}
