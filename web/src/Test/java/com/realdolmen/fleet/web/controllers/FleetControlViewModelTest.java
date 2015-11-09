package com.realdolmen.fleet.web.controllers;

import com.realdolmen.fleet.web.viewmodels.FleetControlViewModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by SDOAX36 on 4/11/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class FleetControlViewModelTest extends Assert{

    private FleetControlViewModel model;

    public void setUp()
    {
        this.model = new FleetControlViewModel(8,8,7,0);
    }

    @Test
    public void checkTotal()
    {
        int total = 8+8+7+0;
        assertEquals(total,model.getTotal());
    }
}
