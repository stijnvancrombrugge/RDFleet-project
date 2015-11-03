package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.Category;

/**
 * Created by SVCAX33 on 2/11/2015.
 */
public class CarModelViewModel {

    private int id;
    private int horsePower;
    private int cilinder;
    private int motorType;
    private int gears;
    private int emission;
    private String line;
    private String model;
    private String mark;
    private Category category;

    public CarModelViewModel(CarModel carModel){
        this.id = carModel.getId();
        this.horsePower = carModel.getHorsePower();
        this.cilinder = carModel.getCilinder();
        this.motorType = carModel.getMotorType();
        this.gears = carModel.getGears();
        this.emission = carModel.getEmission();
        this.line = carModel.getLine();
        this.model = carModel.getModel();
        this.mark = carModel.getMark();
        this.category = carModel.getCategory();
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getCilinder() {
        return cilinder;
    }

    public void setCilinder(int cilinder) {
        this.cilinder = cilinder;
    }

    public int getMotorType() {
        return motorType;
    }

    public void setMotorType(int motorType) {
        this.motorType = motorType;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public int getEmission() {
        return emission;
    }

    public void setEmission(int emission) {
        this.emission = emission;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
