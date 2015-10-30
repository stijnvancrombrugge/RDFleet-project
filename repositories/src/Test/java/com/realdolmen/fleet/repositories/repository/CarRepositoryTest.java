package com.realdolmen.fleet.repositories.repository;

import com.realdolmen.fleet.model.domain.Car;

import java.util.List;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
public class CarRepositoryTest extends AbstractRepoTest{

    private int idToCheckFirst,idToCheckSecond,idToCheckThird;
//TODO : re-make unit tests

    @Override
    public void setUp() throws Exception {
/*        Car car1 = new Car("A3","Audi","Black",0,110,1600,5,5,5,"S-line");
        getCarRepository().save(car1);
        idToCheckFirst = car1.getId();
        Car car2 = new Car("golf","Volkswagen","Black",0,110,1600,5,5,5,"S-line");
        getCarRepository().save(car2);
        idToCheckSecond = car2.getId();
        Car car3 = new Car("Octavia","Skoda","Black",0,110,1600,5,5,5,"S-line");
        getCarRepository().save(car3);
        idToCheckThird = car3.getId();*/

    }

    @Override
    public void shouldCreateEntity() throws Exception {
/*        Car car1 = new Car("Audi","A3","Black",0,110,1600,5,5,5,"S-line");
        getCarRepository().save(car1);
        assertNotNull(car1.getId());*/
    }

    @Override
    public void shouldReturnOnlyOneEntityById() throws Exception {
        Car car = getCarRepository().findOne(idToCheckFirst);
       // assertEquals(car.getCarModel().getMark(),"Audi");
        //assertEquals(car.getModel(),"A3");

    }

    @Override
    public void shouldReturnAllEntities() throws Exception {

        assertEquals(getCarRepository().findAll().size(),3);
    }

    @Override
    public void shouldUpdateAnEntity() throws Exception {

        Car car = getCarRepository().findOne(idToCheckFirst);
        car.setColor("Roze");
        assertEquals(getCarRepository().findOne(idToCheckFirst).getColor(),car.getColor());
    }

    @Override
    public void shouldDeleteAnEntity() throws Exception {

        int size = getCarRepository().findAll().size();
        getCarRepository().delete(idToCheckFirst);
        assertNull(getCarRepository().findOne(idToCheckFirst));
        assertEquals(getCarRepository().findAll().size(),size-1);
    }
}
