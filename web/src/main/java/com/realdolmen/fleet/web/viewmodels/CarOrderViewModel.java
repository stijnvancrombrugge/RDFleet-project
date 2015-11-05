package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.Option;
import com.realdolmen.fleet.model.domain.OptionPack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SVCAX33 on 4/11/2015.
 */
public class CarOrderViewModel {

    private CarModel carModel;
    private String color;
    private List<Option> optionList;

    public CarOrderViewModel(CarModel carModel, List<Option> optionList, String color){
        this.carModel = carModel;
        this.optionList = optionList;
        this.color = color;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }
}
