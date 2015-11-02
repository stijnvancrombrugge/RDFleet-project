package com.realdolmen.fleet.model.domain;

import com.realdolmen.fleet.model.Models.CarModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
@Entity
public class Car extends AbstractEntity{

    public Car() {
    }

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CarModel carModel;

    @NotNull
    private String color;


    private int kilometers;

    @Basic(optional = true)
    private String licensePlate;


    @Basic(optional = true)
    private int basicPrice;


    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<OptionPack> optionPacks;

    public Car(CarModel carModel, String color, int kilometers, String licensePlate, int basicPrice) {
        this.carModel = carModel;
        this.color = color;
        this.kilometers = kilometers;
        this.licensePlate = licensePlate;
        this.basicPrice = basicPrice;
        optionPacks = new ArrayList<>();
    }

    public List<OptionPack> getOptionPacks() {
        return optionPacks;
    }

    public CarModel getCarModel() {

        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
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

    public int getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(int basicPrice) {
        this.basicPrice = basicPrice;
    }

    public void addOptionPack(OptionPack pack)
    {
        this.optionPacks.add(pack);
    }
}
