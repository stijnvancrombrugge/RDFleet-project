package com.realdolmen.fleet.repositories.repository;

import com.realdolmen.fleet.model.domain.Car;
import com.realdolmen.fleet.model.domain.Category;
import org.junit.Test;

import java.util.List;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
public class CategoryRepositoryTest extends AbstractRepoTest {

    private int idToCheckFirst,idToCheckSecond,idToCheckThird;


    @Override
    public void setUp() throws Exception {
        Category cat1 = new Category(1);
        getCategoryRepository().save(cat1);
        idToCheckFirst = cat1.getId();
        Category cat2 = new Category(2);
        getCategoryRepository().save(cat2);
        idToCheckSecond = cat2.getId();
        Category cat3 = new Category(3);
        getCategoryRepository().save(cat3);
        idToCheckThird = cat3.getId();
    }

    @Override
    public void shouldCreateEntity() throws Exception {
        int size = getCategoryRepository().findAll().size();
        Category cat = new Category(1);
        getCategoryRepository().save(cat);
        assertNotNull(cat.getId());
        assertEquals(getCategoryRepository().findAll().size(),size+1);
    }

    @Override
    public void shouldReturnOnlyOneEntityById() throws Exception {
        assertEquals(getCategoryRepository().findOne(idToCheckFirst).getCategoryClass(),1);
    }

    @Override
    public void shouldReturnAllEntities() throws Exception {
        assertEquals(getCategoryRepository().findAll().size(),3);
    }

    @Override
    public void shouldUpdateAnEntity() throws Exception {
        int size = getCategoryRepository().findAll().size();
        Category category = getCategoryRepository().findOne(idToCheckFirst);
        category.setCategoryClass(6);
        assertEquals(getCategoryRepository().findOne(idToCheckFirst).getCategoryClass(), 6, category.getCategoryClass());
        assertEquals(getCategoryRepository().findAll().size(),size);
    }

    @Override
    public void shouldDeleteAnEntity() throws Exception {

        int size = getCategoryRepository().findAll().size();
        System.out.println("Size " + size);
        getCategoryRepository().delete(idToCheckFirst);
        assertNull(getCategoryRepository().findOne(idToCheckFirst));
        assertEquals(getCategoryRepository().findAll().size(),size-1);
    }

    @Test
    public void shouldAddCarToCategory()throws Exception{

 /*       int size = getCarRepository().findAll().size();
        Category category = getCategoryRepository().findOne(idToCheckFirst);
        category.addCar(new Car("A3", "Audi", "Black", 0, 110, 1600, 5, 5, 5, "S-line"));
        assertEquals(getCarRepository().findAll().size(), size + 1);
        assertEquals(getCategoryRepository().findOne(idToCheckFirst).getCars().size(),1);*/
    }

    @Test
    public void shouldRemoveCarFromCategoryCarShouldRemaineInDataBaseButShouldBeRemovedFromCategoryCarList()throws Exception
    {
/*        Category category = getCategoryRepository().findOne(idToCheckFirst);
        Car car1 = new Car("A3","Audi","Black",0,110,1600,5,5,5,"S-line");
        getCarRepository().save(car1);
        int carId = car1.getId();
        category.addCar(car1);
        Car car2 = new Car("golf","Volkswagen","Black",0,110,1600,5,5,5,"S-line");
        getCarRepository().save(car2);
        category.addCar(car2);
        Car car3 = new Car("Octavia","Skoda","Black",0,110,1600,5,5,5,"S-line");
        getCarRepository().save(car3);
        category.addCar(car3);

        category.removeCar(car1);
        assertNotNull(getCarRepository().findOne(carId));

        assertEquals(getCategoryRepository().findOne(idToCheckFirst).getCars().size(),2);*/
    }
}
