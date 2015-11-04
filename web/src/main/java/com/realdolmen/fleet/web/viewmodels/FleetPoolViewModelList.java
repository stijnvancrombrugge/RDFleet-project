package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.domain.CurrentCar;
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

    public class FleetPoolViewModel {


        private String mark;
        private String ownerName;
        private int ownerId;
        private String model;
        private String leasingdate;
        private int km;
        private int id;
        private String kmPercent;


        public FleetPoolViewModel(CurrentCar car) {
            this.mark = car.getCar().getCarModel().getMark();
            this.model = car.getCar().getCarModel().getModel();
            if (car.getEmployee() != null) {
                this.ownerName = car.getEmployee().getFirstName() + " " + car.getEmployee().getLastName();
                this.ownerId = car.getEmployee().getId();
            }

            this.km = car.getCar().getKilometers();
            this.kmPercent = calcPercent(km);
            this.leasingdate = DateUtil.dateToString(car.getLeasingStartDate(), DateUtil.DAY_MONTH_YEAR);
            this.id = car.getId();
        }

        public String getKmPercent() {
            return kmPercent;
        }

        public void setKmPercent(String kmPercent) {
            this.kmPercent = kmPercent;
        }

        public String getMark() {
            return mark;
        }

        public String calcPercent(int km)
        {
            float res = (km*100.0f)/160000;
            return String.format("%.2f", res)+"%";
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public int getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(int ownerId) {
            this.ownerId = ownerId;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getLeasingdate() {
            return leasingdate;
        }

        public void setLeasingdate(String leasingdate) {
            this.leasingdate = leasingdate;
        }

        public int getKm() {
            return km;
        }

        public void setKm(int km) {
            this.km = km;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    }
}
