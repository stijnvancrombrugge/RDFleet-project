package com.realdolmen.fleet.model.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String model;
    @NotNull
    private String mark;
    @NotNull
    private String color;

    @Basic(optional = true)
    private String licensePlate;

    private int kilometers;
    @NotNull
    private int horsePower;
    @NotNull
    private int cilinder;
    @NotNull
    private int motorType;
    @NotNull
    private int gears;
    @NotNull
    private int emission;
    @NotNull
    private String line;
    @Basic(optional = true)
    private int basicPrice;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<OptionPack> optionPacks;

    public Car(String model, String mark, String color, int kilometers, int horsePower, int cilinder, int motorType, int gears, int emission, String line) {
        this.model = model;
        this.mark = mark;
        this.color = color;
        this.kilometers = kilometers;
        this.horsePower = horsePower;
        this.cilinder = cilinder;
        this.motorType = motorType;
        this.gears = gears;
        this.emission = emission;
        this.line = line;
        this.optionPacks = new ArrayList<>();
    }

    public Car() {
        this.optionPacks = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
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

    public int getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(int basicPrice) {
        this.basicPrice = basicPrice;
    }

    public List<OptionPack> getOptionPacks() {
        return optionPacks;
    }

    private void setOptionPacks(List<OptionPack> optionPacks) {
        this.optionPacks = optionPacks;
    }
}
