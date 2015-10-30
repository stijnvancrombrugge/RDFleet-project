package com.realdolmen.fleet.repositories.repository;


import com.realdolmen.fleet.repositories.config.TestConfig;
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

/**
 * Created by SDOAX36 on 28/10/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
@Transactional
public abstract class AbstractRepoTest extends Assert {




    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OptionRepository optionRepository;
    @Autowired
    private OptionPackRepository optionPackRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }

    public OptionRepository getOptionRepository() {
        return optionRepository;
    }

    public OptionPackRepository getOptionPackRepository() {
        return optionPackRepository;
    }


    @Before
    public abstract void setUp()throws Exception;


    /**
     * Create a valid entity.
     * @result use the right repository to save the entity and will be persisted without any errors,
     *         and AbstractEntity.getId() will no longer be <code>null</code>
     */
    @Test
    public abstract void shouldCreateEntity()throws Exception;
    /**
     * Return a single object of abstractEntities.
     * @result use the correct repository.findOne() method each AbstractEntity type will successfully return an object,
     * check if the other variables are consistent with the result object
     * <note>if setUp is changed, change the test</note>
     */
    @Test
    public abstract void shouldReturnOnlyOneEntityById()throws Exception;
    /**
     * Return a list of abstractEntities.
     * @result use the correct repository.findAll() method each AbstractEntity type will successfully return a list of entities with size 3
     * <note>if setUp is changed, change the test</note>
     */
    @Test
    public abstract void shouldReturnAllEntities()throws Exception;
    /**
     * Update a object of abstractEntity.
     * @result use the correct repository.flushAndSave() method to update a variable of the requested object
     *
     */
    @Test
    public abstract void shouldUpdateAnEntity()throws Exception;
    /**
     * Delete an entity.
     * @result use the right repository to delete the entity and will be deleted without any errors,
     *         and AbstractEntity.getId() will be <code>null</code>
     */
    @Test
    public abstract void shouldDeleteAnEntity()throws Exception;

}
