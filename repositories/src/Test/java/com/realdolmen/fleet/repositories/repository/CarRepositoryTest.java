package com.realdolmen.fleet.repositories.repository;

import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.Car;
import com.realdolmen.fleet.model.domain.Category;

import java.util.List;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
public class CarRepositoryTest extends AbstractRepoTest{

    private int idToCheckFirst,idToCheckSecond,idToCheckThird;
//TODO : re-make unit tests

    @Override
    public void setUp() throws Exception {
        //String model, String mark, int horsePower, int cilinder, int motorType, int gears, int emission, String line,Category category
        Car car1 = new Car(new CarModel("A1","Audi",140,1400,11,5,11,"Ecoline",new Category(1)),"Yellow",0,"EES-456",0);
        getCarRepository().save(car1);
        idToCheckFirst = car1.getId();
       // CarModel carModel, String color, int kilometers, String licensePlate, int basicPrice
        Car car2 = new Car(new CarModel("golf","Volkswagen",110,1600,5,5,5,"S-line",new Category(2)),"Yellow",0,"EES-456",0);
        getCarRepository().save(car2);
        idToCheckSecond = car2.getId();
        Car car3 = new Car(new CarModel("Octavia","Skoda",110,1600,5,5,5,"S-line",new Category(2)),"Green",0,"ADD-456",0);
        getCarRepository().save(car3);
        idToCheckThird = car3.getId();

    }

    @Override
    public void shouldCreateEntity() throws Exception {
       //Car car1 = new Car("Audi","A3","Black",0,110,1600,5,5,5,"S-line");
        int size = getCarRepository().findAll().size();
        Car car1 = new Car(new CarModel("A1","Audi",140,1400,11,5,11,"Ecoline",new Category(1)),"Yellow",0,"EES-456",0);
        getCarRepository().save(car1);
        assertNotNull(car1.getId());
        assertEquals(getCarRepository().findAll().size(),size+1);
    }

    @Override
    public void shouldReturnOnlyOneEntityById() throws Exception {
        Car car = getCarRepository().findOne(idToCheckFirst);
        assertEquals(car.getCarModel().getMark(),"Audi");
        assertEquals(car.getCarModel().getModel(),"A1");

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
