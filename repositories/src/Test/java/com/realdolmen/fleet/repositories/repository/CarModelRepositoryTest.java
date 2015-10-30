package com.realdolmen.fleet.repositories.repository;

import com.realdolmen.fleet.model.Models.CarModel;

/**
 * Created by SDOAX36 on 30/10/2015.
 */
public class CarModelRepositoryTest extends AbstractRepoTest {

    //TODO : write repoTests

    private int idToCheckFirst,idToCheckSecond;

    @Override
    public void setUp() throws Exception {
//    public CarModel(String model, String mark, int horsePower, int cilinder, int motorType, int gears, int emission, String line,Integer category) {

        CarModel car1 = new CarModel("A3","Audi",110,1600,5,5,5,"S-line",2);
        getCarModelRepository().save(car1);
        idToCheckFirst = car1.getId();
        CarModel car2 = new CarModel("A4","Audi",140,1900,5,5,5,"S-line",3);
        getCarModelRepository().save(car2);
        idToCheckSecond = car2.getId();
    }

    @Override
    public void shouldCreateEntity() throws Exception {
        CarModel car1 = new CarModel("A3","Audi",110,1600,5,5,5,"S-line",2);
        getCarModelRepository().save(car1);
        assertNotNull(car1.getId());
    }

    @Override
    public void shouldReturnOnlyOneEntityById() throws Exception {
        CarModel model = getCarModelRepository().findOne(idToCheckFirst);
        assertEquals(model.getModel(),"A3");
        assertEquals(model.getMark(),"Audi");
    }

    @Override
    public void shouldReturnAllEntities() throws Exception {
        assertEquals(getCarModelRepository().findAll().size(),2);
    }

    @Override
    public void shouldUpdateAnEntity() throws Exception {
        CarModel model = getCarModelRepository().findOne(idToCheckFirst);
        model.setCategory(3);
        assertEquals(getCarModelRepository().findOne(idToCheckFirst).getCategory(),new Integer(3));
    }

    @Override
    public void shouldDeleteAnEntity() throws Exception {
        int size = getCarModelRepository().findAll().size();
        getCarModelRepository().delete(idToCheckFirst);
        assertEquals(getCarModelRepository().findAll().size(),size-1);
        assertNull(getCarModelRepository().findOne(idToCheckFirst));

    }
}
