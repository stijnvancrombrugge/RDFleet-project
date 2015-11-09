package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.domain.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDOAX36 on 6/11/2015.
 */
public class OwnerViewList  {

    private List<OwnerDetailViewModel> owners;

    public OwnerViewList(List<Employee>employees)
    {
        owners = new ArrayList<>();
        fillList(employees);
    }

    public List<OwnerDetailViewModel> getOwners() {
        return owners;
    }

    public void setOwners(List<OwnerDetailViewModel> owners) {
        this.owners = owners;
    }

    private void fillList(List<Employee>employees)
    {
        if(owners == null)
        {
            owners = new ArrayList<>();
        }
        for(Employee e : employees)
        {
            owners.add(new OwnerDetailViewModel(e));
        }
    }
}
