package com.realdolmen.fleet.security.config.Config;

import com.realdolmen.fleet.security.config.Handlers.UserSuccessHandler;
import com.realdolmen.fleet.services.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/**
 * Created by SVCAX33 on 28/10/2015.
 */

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    UserDetailService service;


    @Autowired
    UserSuccessHandler successHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(service);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .formLogin()
                .loginPage("/login")
                .successHandler(successHandler)
                //.defaultSuccessUrl("/employee/home")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .rememberMe()
                .tokenValiditySeconds(1000)
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/index").and()
                .authorizeRequests()
                /*.antMatchers("/fleet/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/employee/**").access("hasRole('ROLE_USER')")*/
                .anyRequest().permitAll().and().httpBasic();
    }
}
