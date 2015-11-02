package com.realdolmen.fleet.webservices.endpoints.services;

import com.realdolmen.fleet.webservices.endpoints.CarModelXml;

/**
 * Created by SDOAX36 on 30/10/2015.
 */
public class CarModelBuilder {

    private CarModelXml carModel;

    public CarModelBuilder()
    {

    }

    private int id;
    public CarModelBuilder setId(int id)
    {
        this.id = id;
        return this;
    }

    private String model;
    public CarModelBuilder setModel(String m)
    {
        this.model = model;
        return this;
    }
    private String mark;

    public CarModelBuilder setMark(String m)
    {
        this.mark = mark;
        return this;
    }

    private int horsePower;
    public CarModelBuilder setHorsePower(int h)
    {
        this.horsePower = horsePower;
        return this;

    }

    private int cilinder;
    public CarModelBuilder setCilinder(int cilinder)
    {
        this.cilinder = cilinder;
        return this;
    }

    private int motorType;
    public CarModelBuilder setMotorType(int motorType)
    {
        this.motorType = motorType;
        return this;
    }

    private int gears;
    public CarModelBuilder setGears(int gears)
    {
        this.gears = gears;
        return this;
    }

    private int emission;
    public CarModelBuilder setEmission(int emission)
    {
        this.emission = emission;
        return this;
    }
    private String line;
    public CarModelBuilder setLine(String line)
    {
        this.line = line;
        return this;
    }
    private int category;
    public CarModelBuilder setCategory(int category)
    {
        this.category = category;
        return this;
    }

    public CarModelXml build()
    {
        this.carModel = new CarModelXml();
        carModel.setModel(model);
        carModel.setMark(mark);
        carModel.setHorsePower(horsePower);
        carModel.setCilinder(cilinder);
        carModel.setMotorType(motorType);
        carModel.setGears(gears);
        carModel.setEmission(emission);
        carModel.setLine(line);
        carModel.setCategory(category);
        return carModel;
    }

}

