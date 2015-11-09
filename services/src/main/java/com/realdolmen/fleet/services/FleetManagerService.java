package com.realdolmen.fleet.services;

import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.model.domain.FleetManager;
import com.realdolmen.fleet.repositories.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SDOAX36 on 2/11/2015.
 */
@Service
public class FleetManagerService {

    @Autowired
    UserRepository userRepository;

    public FleetManager findFleetManager(int id) throws Exception
    {
        return (FleetManager)userRepository.findOne(id);
    }

    public List<FleetManager>findAllManagers()
    {
        return (List<FleetManager>)(List<?>)userRepository.findAll();
    }

    public void saveFleetManager(FleetManager fleetManager)
    {
        userRepository.save(fleetManager);
    }

}
