package com.realdolmen.fleet.repositories.repository;

import com.realdolmen.fleet.model.domain.*;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.ConstraintViolationException;
import java.util.Date;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
public class UserRepositoryTest extends AbstractRepoTest {

    private int id;

    @Override
    public void setUp() throws Exception {

        User user1 = new Employee("sdoax361","password",new Date(),"slsdjkf@smdljf.be",new Category(1));
        getUserRepository().save(user1);
        id = user1.getId();
    }

    @Override
    public void shouldCreateEntity() throws Exception {

        User user = new Employee("sdoax36","password",new Date(),"slsdjkf@smdljf.be",new Category(1));
        getUserRepository().save(user);
        assertNotNull(user.getId());
    }

    @Override
    public void shouldReturnOnlyOneEntityById() throws Exception {

        assertEquals(getUserRepository().findOne(id).getUsername(), "sdoax361");
        assertEquals(getUserRepository().findOne(id).getEmail(), "slsdjkf@smdljf.be");
    }

    @Override
    public void shouldReturnAllEntities() throws Exception {
        assertEquals(getUserRepository().findAll().size(),1);

    }

    @Override
    public void shouldUpdateAnEntity() throws Exception {

        User user = getUserRepository().findOne(id);
        user.setFirstName("Steven");
        user.setLastName("De Cock");

        assertEquals(getUserRepository().findOne(id).getFirstName(), "Steven");
        assertEquals(getUserRepository().findOne(id).getLastName(),"De Cock");

    }

    @Override
    public void shouldDeleteAnEntity() throws Exception {

        int size = getUserRepository().findAll().size();
        //should be 1
        getUserRepository().delete(id);
        assertNull(getUserRepository().findOne(id));
        assertEquals(getUserRepository().findAll().size(),size-1);

    }

    @Test(expected = DataIntegrityViolationException.class)
    public void cannotPersistUserWithSameUserName()throws Exception
    {
        User user = new Employee("sdoax361","password",new Date(),"slsdjkf@smdljf.be",new Category(1));
        getUserRepository().save(user);
        assertNull(user.getId());
    }

    @Test(expected = ConstraintViolationException.class)
    public void cannotPersistUserWithWrongEmailFormat()throws Exception
    {
        User user = new Employee("sdoax1","password",new Date(),"slsdjkf//wrong",new Category(1));
        getUserRepository().save(user);
        assertNull(user.getId());
    }
    @Test
    public void shouldAddANewOrderToTheList()throws Exception
    {
        Employee user =(Employee)getUserRepository().findOne(id);
        Order order = new Order(new Car("Octavia","Skoda","Black",0,110,1600,5,5,5,"S-line"),false);
        getOrderRepository().save(order);
        user.addOrder(order);
        getUserRepository().saveAndFlush(user);
        assertNotNull(order.getId());
        assertEquals(getOrderRepository().findAll().size(),1);

    }
}
