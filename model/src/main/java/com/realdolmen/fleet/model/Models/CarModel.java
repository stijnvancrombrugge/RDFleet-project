package com.realdolmen.fleet.model.Models;

import com.realdolmen.fleet.model.domain.AbstractEntity;
import com.realdolmen.fleet.model.domain.Category;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


/**
 * Created by SDOAX36 on 30/10/2015.
 */

@Entity
public class CarModel extends AbstractEntity{


    private byte[] image;
    private String dealerName;
    @NotNull
    private String model;
    @NotNull
    private String mark;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

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

    public CarModel() {
    }

    public CarModel(String model, String mark, int horsePower, int cilinder, int motorType, int gears, int emission, String line,Category category) {
        this.model = model;
        this.mark = mark;
        this.horsePower = horsePower;
        this.cilinder = cilinder;
        this.motorType = motorType;
        this.gears = gears;
        this.emission = emission;
        this.line = line;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CarModel(byte[] image, String dealerName, String model, String mark, int horsePower, int cilinder, int motorType, int gears, int emission, String line,Category category) {
        this.image = image;
        this.dealerName = dealerName;
        this.model = model;
        this.mark = mark;
        this.horsePower = horsePower;
        this.cilinder = cilinder;
        this.motorType = motorType;
        this.gears = gears;
        this.emission = emission;
        this.line = line;
        this.category = category;

    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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
}
