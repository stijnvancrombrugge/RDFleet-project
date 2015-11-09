package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.domain.CurrentCar;
import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.services.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDOAX36 on 4/11/2015.
 */

public class FleetPoolViewModelList {

    private List<FleetPoolViewModel> models;

    public FleetPoolViewModelList(List<CurrentCar> currentCars) {
        createList(currentCars);
    }

    private void createList(List<CurrentCar> cars) {
        models = new ArrayList<>();
        for (CurrentCar car : cars) {
            models.add(new FleetPoolViewModel(car));
        }
    }

    public List<FleetPoolViewModel> getModels() {
        return models;
    }

    public void setModels(List<FleetPoolViewModel> models) {
        this.models = models;
    }




}
