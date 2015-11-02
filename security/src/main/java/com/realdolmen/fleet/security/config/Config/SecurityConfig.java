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

<<<<<<< HEAD
<<<<<<< HEAD:security/src/main/java/com/realdolmen/fleet/security/config/Config/SecurityConfig.java
=======
>>>>>>> refs/remotes/origin/master
   @Autowired
    UserSuccessHandler successHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .userDetailsService(service);
<<<<<<< HEAD
                //password encoder should be placed here
=======
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, true from User where username=?")
                .authoritiesByUsernameQuery("select username, role from User where username=?");
        //.passwordEncoder(new StandardPasswordEncoder("53cr3t"));

>>>>>>> refs/remotes/origin/master:security/src/main/java/com/realdolmen/fleet/security/config/SecurityConfig.java
=======
        //password encoder should be placed here
>>>>>>> refs/remotes/origin/master
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .formLogin()
<<<<<<< HEAD
<<<<<<< HEAD:security/src/main/java/com/realdolmen/fleet/security/config/Config/SecurityConfig.java
=======
>>>>>>> refs/remotes/origin/master
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
                .antMatchers("/fleet/**").access("hasRole('ADMIN')")
                .antMatchers("/employee/**").access("hasRole('USER')")
<<<<<<< HEAD
=======
                .loginPage("/index").usernameParameter("username").passwordParameter("password").and()
                .rememberMe().tokenValiditySeconds(1000).and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").and()
                .authorizeRequests()/*
                .antMatchers("/fleet/**").hasRole("ADMIN")
                .antMatchers("/employee/**").hasRole("USER")*/
>>>>>>> refs/remotes/origin/master:security/src/main/java/com/realdolmen/fleet/security/config/SecurityConfig.java
=======
>>>>>>> refs/remotes/origin/master
                .anyRequest().permitAll().and().httpBasic();
    }
}
