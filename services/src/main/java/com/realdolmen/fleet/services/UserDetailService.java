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
    public UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       System.out.println("LoadUserByUserName "+s);
        User user = getUserByUsername(s);
        if(user != null)
        {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);

        }
        throw new UsernameNotFoundException("User "+s+" Not found");
    }

    public Integer getIdFromUserByUserName(String s)throws UsernameNotFoundException
    {
        User user = getUserByUsername(s);
        if(user != null)
        {
            return user.getId();
        }

        throw new UsernameNotFoundException("User "+s+" not found");
    }

    private User getUserByUsername(String s) throws UsernameNotFoundException
    {
        Optional<User>user = userRepository.findByUsername(s);
        if(user != null)
        {
            return user.get();
        }

       return null;
    }

    private User getUserById(int id)
    {
        return userRepository.findOne(id);
    }
}
