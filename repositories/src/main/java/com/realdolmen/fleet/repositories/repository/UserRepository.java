package com.realdolmen.fleet.repositories.repository;

import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);



}
