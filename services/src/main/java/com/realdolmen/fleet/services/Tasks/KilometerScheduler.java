package com.realdolmen.fleet.services.Tasks;

import com.realdolmen.fleet.model.domain.Car;
import com.realdolmen.fleet.repositories.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by SDOAX36 on 5/11/2015.
 */
@Component
public class KilometerScheduler {

    @Autowired
    CarRepository repository;

    @Scheduled(fixedRate = 360000)
    public void addRandomKilometersToCar()
    {
        iterateList();
    }

    private void iterateList()
    {
        for(Car c : repository.findAll())
        {

            int km = randomKilometers();
            c.setKilometers(c.getKilometers()+randomKilometers());
            System.out.println("Car "+c.getId()+" km + "+km);
            repository.save(c);
        }
    }

    private int randomKilometers()
    {
        Random rand = new Random();
        return rand.nextInt(100);
    }
}
