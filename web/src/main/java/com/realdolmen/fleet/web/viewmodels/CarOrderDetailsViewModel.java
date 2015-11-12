package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.Car;
import com.realdolmen.fleet.model.domain.Option;
import com.realdolmen.fleet.model.domain.OptionPack;

import java.util.List;

/**
 * Created by SDOAX36 on 10/11/2015.
 */
public class CarOrderDetailsViewModel {

    private String mark;
    private String model;
    private int modelId;
    private String color;
    private List<String>options;

    public CarOrderDetailsViewModel(Car car) {
        mark = car.getCarModel().getMark();
        model = car.getCarModel().typeString();
        modelId = car.getCarModel().getId();
        color = car.getColor();

        filloptionsList(car);
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    private void filloptionsList(Car car)
    {
        for(OptionPack pack : car.getOptionPacks())
        {
            for(Option option : pack.getOptions())
            {
                options.add(option.getOptionName());
            }
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
