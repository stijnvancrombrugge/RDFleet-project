package com.realdolmen.fleet.repositories.repository;

import com.realdolmen.fleet.model.domain.Option;

import org.junit.Test;

import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * Created by SDOAX36 on 28/10/2015.
*/
public class OptionRepoTest extends AbstractRepoTest{


    @Test
    public void shouldPersistOption()throws Exception
    {
        Option option1 = new Option("MP3 player");
        getOptionRepository().save(option1);
        assertNotNull(option1.getId());

    }

    @Test
    public void shouldRetrieveAnOptionByID()throws Exception
    {
        Option option = getOptionRepository().findOne(1);
        assertEquals(option.getOptionName(), "MP3 player");
        Option option1 = getOptionRepository().findOne(2);
        assertEquals(option1.getOptionName(), "Audio System");
    }

    @Test
    public void shouldRetrieveListOfOptions()throws Exception
    {
        List<Option>optionsList = getOptionRepository().findAll();
        assertEquals(optionsList.size(),2);
    }

    @Test
    public void shouldUpdateOptionName()throws Exception
    {
        Option option = getOptionRepository().findOne(1);
        option.setOptionName("MP3 Bose system");
        getOptionRepository().saveAndFlush(option);
        assertEquals(getOptionRepository().findOne(1).getOptionName(),option.getOptionName());
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
}
