package com.realdolmen.fleet.repositories.repository;

import com.realdolmen.fleet.model.domain.Option;

import com.realdolmen.fleet.model.domain.OptionPack;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * Created by SDOAX36 on 28/10/2015.
*/
public class OptionRepoTest extends AbstractRepoTest{

    private int idToCheckFirst;
    private int idToCheckSecond;
    private int idToCheckThird;

    @Override
    public void setUp() throws Exception {

        System.out.println("Is this shit doing what it is supose to do?");
        Option option1 = new Option("MP3 player");
        getOptionRepository().save(option1);
        idToCheckFirst = option1.getId();
        Option option2 = new Option("Audio System");
        getOptionRepository().save(option2);
        idToCheckSecond = option2.getId();
        Option option3 = new Option("Audio System Advanced");
        getOptionRepository().save(option3);
        idToCheckThird = option3.getId();

    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldNotSaveOptionWithoutOptionName()throws Exception
    {
        Option option = new Option();
        getOptionRepository().save(option);
        assertNull(option.getId());
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldNotSaveOptionWithOptionNameToLong()throws Exception
    {
        Option option = new Option("dmlskfjqsdmklfjqsdmlkfjsdmlkjfsdmlqkjfmlsdkjfsdmlkqjfqmlsdkjfmlqsdkjfsdmljkfsdmlkfjqsmldkjfqsdmlkfjqsdmlkfjsdmlkfjsdmlkjfmsdljkfqmlsdkfj");
        getOptionRepository().save(option);
        assertNull(option.getId());
    }


    @Override
    public void shouldCreateEntity() throws Exception {
        Option option1 = new Option("MP3 player");
        getOptionRepository().save(option1);
        assertNotNull(option1.getId());
    }

    @Override
    public void shouldReturnOnlyOneEntityById() throws Exception {
        Option option = getOptionRepository().findOne(idToCheckFirst);
        assertEquals(option.getOptionName(), "MP3 player");
        Option option1 = getOptionRepository().findOne(idToCheckSecond);
        assertEquals(option1.getOptionName(), "Audio System");
    }

    @Override
    public void shouldReturnAllEntities() throws Exception {
        List<Option>optionsList = getOptionRepository().findAll();
        assertEquals(optionsList.size(),3);
    }

    @Override
    public void shouldUpdateAnEntity() throws Exception {
        Option option = getOptionRepository().findOne(idToCheckFirst);
        option.setOptionName("MP3 Bose system");
        //getOptionRepository().saveAndFlush(option);
        assertEquals(getOptionRepository().findOne(idToCheckFirst).getOptionName(),option.getOptionName());
    }

    @Override
    public void shouldDeleteAnEntity() throws Exception {
       getOptionRepository().delete(idToCheckFirst);
       assertNull(getOptionRepository().findOne(idToCheckFirst));
    }
}
