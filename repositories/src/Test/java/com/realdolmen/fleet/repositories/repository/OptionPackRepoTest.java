package com.realdolmen.fleet.repositories.repository;

import com.realdolmen.fleet.model.domain.Option;
import com.realdolmen.fleet.model.domain.OptionPack;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
public class OptionPackRepoTest extends AbstractRepoTest{

    private int idToCheckFirst;
    private int idToCheckSecond;
    private int idToCheckThird;

    @Override
    public void setUp() throws Exception {


        OptionPack pack = new OptionPack("Economic line");
        getOptionPackRepository().save(pack);
        idToCheckFirst = pack.getId();
        OptionPack pack1 = new OptionPack("Business Pack");
        getOptionPackRepository().save(pack1);
        idToCheckSecond = pack1.getId();
        OptionPack pack2 = new OptionPack("Executive line");
        getOptionPackRepository().save(pack2);
        idToCheckThird = pack2.getId();

    }

    @Override
    public void shouldCreateEntity() throws Exception {
        OptionPack pack = new OptionPack("Economic line");
        getOptionPackRepository().save(pack);
        assertNotNull(pack.getId());
    }

    @Override
    public void shouldReturnOnlyOneEntityById() throws Exception {
        OptionPack pack = getOptionPackRepository().findOne(idToCheckFirst);
        assertEquals(pack.getName(),"Economic line");
        OptionPack pack1 = getOptionPackRepository().findOne(idToCheckSecond);
        assertEquals(pack1.getName(), "Business Pack");
        OptionPack pack2 = getOptionPackRepository().findOne(idToCheckThird);
        assertEquals(pack2.getName(), "Executive line");
    }

    @Override
    public void shouldReturnAllEntities() throws Exception {

        List<OptionPack> optionPacks = getOptionPackRepository().findAll();
        assertEquals(optionPacks.size(),3);
    }

    @Override
    public void shouldUpdateAnEntity() throws Exception {
        String newName = "UpdateName";
        OptionPack pack = getOptionPackRepository().findOne(idToCheckFirst);
        pack.setName(newName);
        //without saving???
        assertEquals(getOptionPackRepository().findOne(idToCheckFirst).getName(),newName);

    }

    @Test
    public void shouldAddAndPersisitOptionsInTheOptionPack()throws Exception
    {
        OptionPack pack = getOptionPackRepository().findOne(idToCheckFirst);
        int size = pack.getOptions().size();
        int repoSize = getOptionRepository().findAll().size();
        pack.addOption(new Option("More"));
        pack.addOption(new Option("one more"));
        //getOptionPackRepository().saveAndFlush(pack);
        assertEquals(pack.getOptions().size(),size+2);
        assertEquals(getOptionPackRepository().findOne(idToCheckFirst).getOptions().size(),size+2);
        assertEquals(getOptionRepository().findAll().size(),repoSize+2);

    }

    @Override
    public void shouldDeleteAnEntity() throws Exception {

        getOptionPackRepository().delete(idToCheckFirst);
        assertNull(getOptionPackRepository().findOne(idToCheckFirst));
    }
}
