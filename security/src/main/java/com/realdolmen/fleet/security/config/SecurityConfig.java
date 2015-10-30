package com.realdolmen.fleet.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
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
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, true from User where username=?")
                .authoritiesByUsernameQuery("select username, 'ROLE_USER' from User where username=?")
                .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .formLogin()
                .loginPage("/login").and()
                .rememberMe().tokenValiditySeconds(1000).and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/index").and()
                .authorizeRequests()
                /*.antMatchers("/fleetHome").hasRole("FleetManager")
                .antMatchers("/employee/**").hasRole("Employee")*/
                .anyRequest().permitAll();
    }
}
