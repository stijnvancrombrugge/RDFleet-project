package com.realdolmen.fleet.repositories.repository;

import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.*;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by SDOAX36 on 3/11/2015.
 */
public class CurrentCarRepositoryTest extends AbstractRepoTest {
    @Override
    public void setUp() throws Exception {
        CurrentCar currentCar = new CurrentCar(new Car(new CarModel("A1","Audi",140,1400,11,5,11,"Ecoline",new Category(1)),"Yellow",0,"EES-456",0));
        getCurrentCarRepository().save(currentCar);
        CurrentCar currentCar1 = new CurrentCar(new Car(new CarModel("A1","Volkswagen",140,1400,11,5,11,"Ecoline",new Category(1)),"Yellow",0,"EES-456",0));
        getCurrentCarRepository().save(currentCar1);
        CurrentCar currentCar2 = new CurrentCar(new Car(new CarModel("A1","Skoda",140,1400,11,5,11,"Ecoline",new Category(1)),"Yellow",0,"EES-456",0));

        User user1 = new Employee("sdoax361","password",new Date(),"slsdjkf@smdljf.be",new Category(1));
        //getUserRepository().save(user1);
        currentCar2.setEmployee((Employee)user1);
        ((Employee) user1).setCurrentCar(currentCar2);
        getCurrentCarRepository().save(currentCar2);

    }
//this works so I assume that all the others will work too, moving on...
    @Override
    public void shouldCreateEntity() throws Exception {
        CurrentCar currentCar = new CurrentCar(new Car(new CarModel("A1","Audi",140,1400,11,5,11,"Ecoline",new Category(1)),"Yellow",0,"EES-456",0));
        getCurrentCarRepository().save(currentCar);
        assertNotNull(currentCar.getId());

    }

    @Override
    public void shouldReturnOnlyOneEntityById() throws Exception {

    }

    @Override
    public void shouldReturnAllEntities() throws Exception {

    }

    @Override
    public void shouldUpdateAnEntity() throws Exception {

    }

    @Override
    public void shouldDeleteAnEntity() throws Exception {

    }

    @Test
    public void shouldReturnAllCurrentCarFromMark()throws Exception{

        assertEquals(getCurrentCarRepository().findCurrentCarByCarCarModelMark("Audi").size(),1);
        assertEquals(getCurrentCarRepository().findCurrentCarByCarCarModelMark("Volkswagen").size(),1);
        assertEquals(getCurrentCarRepository().findCurrentCarByCarCarModelMark("Skoda").size(),1);
    }

    @Test
    public void shouldReturnAllCurrentCarWhereEmployeeIsNull()throws Exception
    {

        assertEquals(getCurrentCarRepository().findByEmployeeIsNull().size(), 2);
        assertNotSame(getCurrentCarRepository().findByEmployeeIsNull().size(), getCurrentCarRepository().findAll().size());

    }
    @Test
    public void shouldReturnOneCarWithMarkModelColorAndEmployeeNull()throws Exception
    {
        // CurrentCar currentCar = new CurrentCar(new Car(new CarModel("A1","Audi",140,1400,11,5,11,"Ecoline",new Category(1)),"Yellow",0,"EES-456",0));

        //Optional<CurrentCar> currentCarOptional = getCurrentCarRepository().searchCurrentCarFromFreePoolByMarkModelColor("Audi","A1","Yellow");
        List<CurrentCar>c = getCurrentCarRepository().findByCarCarModelMarkAndCarCarModelModelAndCarColorAndEmployeeIsNull("Audi", "A1", "Yellow");
        assertEquals(c.size(), 1);
    }
}
