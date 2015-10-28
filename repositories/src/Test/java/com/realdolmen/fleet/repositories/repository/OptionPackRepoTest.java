package com.realdolmen.fleet.repositories.repository;

import com.realdolmen.fleet.model.domain.OptionPack;
import org.junit.Test;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
public class OptionPackRepoTest extends AbstractRepoTest{


    @Test
    public void testShouldCreateNewOptionPack() throws Exception {

        OptionPack pack = new OptionPack("Economic line");
        getOptionPackRepository().save(pack);
        assertNotNull(pack.getId());

    }


    @Test
    public void testShouldReturnAnOptionPackById() throws Exception {

        OptionPack pack = getOptionPackRepository().findOne(1);
        assertEquals(pack.getName(),"Economic line");
        OptionPack pack1 = getOptionPackRepository().findOne(2);
        assertEquals(pack1.getName(), "Business Pack");
        OptionPack pack2 = getOptionPackRepository().findOne(3);
        assertEquals(pack2.getName(),"Executive line");

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
