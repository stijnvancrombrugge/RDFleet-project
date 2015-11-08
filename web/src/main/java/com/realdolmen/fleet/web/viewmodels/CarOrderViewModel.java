package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.Option;
import com.realdolmen.fleet.model.domain.OptionPack;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SVCAX33 on 4/11/2015.
 */
public class CarOrderViewModel {

    private int carModelId;

    @NotNull
    private String color;
    List<Integer> optionList;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(int carModelId) {
        this.carModelId = carModelId;
     }

    public List<Integer> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Integer> optionList) {
        this.optionList = optionList;
    }
}
