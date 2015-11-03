package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.Car;
import com.realdolmen.fleet.model.domain.OptionPack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SVCAX33 on 2/11/2015.
 */
public class CarViewModel {

    private int id;
    private String color;
    private int kilometers;
    private String licensePlate;
    private int basicPrice;
    private CarModel carModel;
    List<OptionPackViewModel> optionPackViewModelList;
    
    public CarViewModel(Car car){
        this.id = car.getId();
        this.color = car.getColor();
        this.kilometers = car.getKilometers();
        this.licensePlate = car.getLicensePlate();
        this.carModel = car.getCarModel();
        this.optionPackViewModelList = new ArrayList<>();
        for(OptionPack optionPack: car.getOptionPacks()){
            optionPackViewModelList.add(new OptionPackViewModel(optionPack));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }


    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public List<OptionPackViewModel> getOptionPackViewModelList() {
        return optionPackViewModelList;
    }

    public void setOptionPackViewModelList(List<OptionPackViewModel> optionPackViewModelList) {
        this.optionPackViewModelList = optionPackViewModelList;
    }
}
