package com.realdolmen.fleet.model.domain;

import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * Created by SVCAX33 on 28/10/2015.
 */

@Entity
public class FleetManager extends User{

    public FleetManager(String username, String password, String email, LocalDate birthDate) {
        super(username, password, email, birthDate, "FleetManager");
    }
}
