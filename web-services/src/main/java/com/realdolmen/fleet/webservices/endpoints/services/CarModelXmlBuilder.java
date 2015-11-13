package com.realdolmen.fleet.webservices.endpoints.services;

import com.realdolmen.fleet.webservices.endpoints.CarModelXml;

/**
 * Created by SDOAX36 on 30/10/2015.
 */
public class CarModelXmlBuilder {

    private CarModelXml carModel;

    public CarModelXmlBuilder()
    {

    }

    private int id;
    public CarModelXmlBuilder setId(int id)
    {
        this.id = id;
        return this;
    }

    private String model;
    public CarModelXmlBuilder setModel(String m)
    {
        this.model = m;
        return this;
    }
    private String mark;

    public CarModelXmlBuilder setMark(String m)
    {
        this.mark = m;
        return this;
    }

    private int horsePower;
    public CarModelXmlBuilder setHorsePower(int h)
    {
        this.horsePower = h;
        return this;

    }

    private int cilinder;
    public CarModelXmlBuilder setCilinder(int cilinder)
    {
        this.cilinder = cilinder;
        return this;
    }

    private int motorType;
    public CarModelXmlBuilder setMotorType(int motorType)
    {
        this.motorType = motorType;
        return this;
    }

    private int gears;
    public CarModelXmlBuilder setGears(int gears)
    {
        this.gears = gears;
        return this;
    }

    private int emission;
    public CarModelXmlBuilder setEmission(int emission)
    {
        this.emission = emission;
        return this;
    }
    private String line;
    public CarModelXmlBuilder setLine(String line)
    {
        this.line = line;
        return this;
    }
    private int category;
    public CarModelXmlBuilder setCategory(int category)
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
        carModel.setId(id);
        return carModel;
    }

}

