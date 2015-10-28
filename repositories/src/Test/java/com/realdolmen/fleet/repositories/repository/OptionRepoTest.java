package com.realdolmen.fleet.repositories.repository;

import com.realdolmen.fleet.repositories.config.TestConfig;
import com.realdolmen.fleet.model.domain.Option;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
@Transactional
public class OptionRepoTest extends Assert{

    @Autowired
    OptionRepository repository;

   @Before
    public void init()
    {
        Option option1 = new Option("MP3 player");
        repository.save(option1);
        Option option2 = new Option("Audio System");
        repository.save(option2);

    }

    @Test
    public void shouldPersistOption()throws Exception
    {
        Option option1 = new Option("MP3 player");
        repository.save(option1);
        assertNotNull(option1.getId());

    }

    @Test
    public void shouldRetrieveAnOptionByID()throws Exception
    {
        Option option = repository.findOne(1);
        assertEquals(option.getOptionName(), "MP3 player");
        Option option1 = repository.findOne(2);
        assertEquals(option1.getOptionName(), "Audio System");
    }

    @Test
    public void shouldRetrieveListOfOptions()throws Exception
    {
        List<Option>optionsList = repository.findAll();
        assertEquals(optionsList.size(),2);
    }

    @Test
    public void shouldUpdateOptionName()throws Exception
    {
        Option option = repository.findOne(1);
        option.setOptionName("MP3 Bose system");
        repository.save(option);
        assertEquals(repository.findOne(1).getOptionName(),option.getOptionName());
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldNotSaveOptionWithoutOptionName()throws Exception
    {
        Option option = new Option();
        repository.save(option);
        assertNull(option.getId());
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldNotSaveOptionWithOptionNameToLong()throws Exception
    {
        Option option = new Option("dmlskfjqsdmklfjqsdmlkfjsdmlkjfsdmlqkjfmlsdkjfsdmlkqjfqmlsdkjfmlqsdkjfsdmljkfsdmlkfjqsmldkjfqsdmlkfjqsdmlkfjsdmlkfjsdmlkjfmsdljkfqmlsdkfj");
        repository.save(option);
        assertNull(option.getId());
    }


}
