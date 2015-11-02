package com.realdolmen.fleet.services;

import com.realdolmen.fleet.model.domain.User;
import com.realdolmen.fleet.repositories.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by SDOAX36 on 2/11/2015.
 */
@Service
public class UserDetailService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       System.out.println("LoadUserByUserName "+s);
        Optional<User> user = userRepository.findByUsername(s);

        if(user!=null)
        {
            User realUser = user.get();
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(realUser.getRole()));
            System.out.println("LoadUserByUsername : " + realUser.getId() + " should be logged in as "+realUser.getRole()+" autorities "+authorities.get(0));
            return new org.springframework.security.core.userdetails.User(realUser.getUsername(),realUser.getPassword(),authorities);

        }
        throw new UsernameNotFoundException("User "+s+" Not found");
    }
}
