package com.realdolmen.fleet.repositories.repository;

import com.realdolmen.fleet.model.domain.*;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.List;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
public class UserRepositoryTest extends AbstractRepoTest {

    private int idToCheckFirst,idToCheckSecond,idToCheckThird;

    @Override
    public void setUp() throws Exception {

        User user1 = new Employee("sdoax361","password",new Date(),"slsdjkf@smdljf.be",new Category(1));
        getUserRepository().save(user1);
        idToCheckFirst = user1.getId();

        User user2 = new Employee("sdoax363","password",new Date(),"slsdjkf@smdljfsqdf.be",new Category(1));
        getUserRepository().save(user2);
        idToCheckSecond= user2.getId();
//(String username, String password, String email, Date birthDate)
        User user3 = new FleetManager("sdoax36sqf1","password","slsdjkf@smdljf.be",new Date());
        getUserRepository().save(user3);
        idToCheckFirst = user3.getId();
    }

    @Override
    public void shouldCreateEntity() throws Exception {

        User user = new Employee("sdoax36","password",new Date(),"slsdjkf@smdljf.be",new Category(1));
        getUserRepository().save(user);
        assertNotNull(user.getId());
    }

    @Override
    public void shouldReturnOnlyOneEntityById() throws Exception {

        assertEquals(getUserRepository().findOne(idToCheckFirst).getUsername(), "sdoax361");
        assertEquals(getUserRepository().findOne(idToCheckFirst).getEmail(), "slsdjkf@smdljf.be");
    }

    @Override
    public void shouldReturnAllEntities() throws Exception {
        assertEquals(getUserRepository().findAll().size(),1);

    }

    @Override
    public void shouldUpdateAnEntity() throws Exception {

        User user = getUserRepository().findOne(idToCheckFirst);
        user.setFirstName("Steven");
        user.setLastName("De Cock");

        assertEquals(getUserRepository().findOne(idToCheckFirst).getFirstName(), "Steven");
        assertEquals(getUserRepository().findOne(idToCheckFirst).getLastName(),"De Cock");

    }

    @Override
    public void shouldDeleteAnEntity() throws Exception {

        int size = getUserRepository().findAll().size();
        //should be 1
        getUserRepository().delete(idToCheckFirst);
        assertNull(getUserRepository().findOne(idToCheckFirst));
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


}
