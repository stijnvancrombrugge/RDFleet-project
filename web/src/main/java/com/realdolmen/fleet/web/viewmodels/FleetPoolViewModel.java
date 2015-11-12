package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.domain.CurrentCar;
import com.realdolmen.fleet.services.util.DateUtil;

import java.util.Collection;

/**
 * Created by SDOAX36 on 5/11/2015.
 */
public class FleetPoolViewModel {


    private String mark;
    private String ownerName;
    private int ownerId;
    private String model;
    private String leasingdate;
    private int km;
    private int id;
    private String kmPercent;
    private int kmNeg;
    private String kmPercentNeg;

    //for details
    private int carModelId;
    private String modelType;
    private String endLeasing;
    private String color;
    private Integer[] kmArray;

    private OwnerDetailViewModel ownerDetails;



    public FleetPoolViewModel(CurrentCar car) {
        this.mark = car.getCar().getCarModel().getMark();
        this.model = car.getCar().getCarModel().getModel();
        if (car.getEmployee() != null) {
            this.ownerName = car.getEmployee().getFirstName() + " " + car.getEmployee().getLastName();
            this.ownerId = car.getEmployee().getId();
        }

        this.km = car.getCar().getKilometers();
        this.kmPercent = calcPercent(km);
        this.kmNeg = 160000 - km;
        this.kmPercentNeg = calcPercent(kmNeg);

        this.leasingdate = DateUtil.dateToString(car.getLeasingStartDate(), DateUtil.DAY_MONTH_YEAR);
        this.id = car.getId();
        this.carModelId = car.getCar().getCarModel().getId();
        this.modelType = car.getCar().getCarModel().typeString();
        this.color = car.getCar().getColor();
        this.endLeasing = DateUtil.endLeaseDate(car.getLeasingStartDate());

        if(car.getEmployee()!=null)
        {
            this.ownerDetails = new OwnerDetailViewModel(car.getEmployee());
        }

        this.kmArray = new Integer[car.getCar().getKmEvolution().size()];
        car.getCar().getKmEvolution().toArray(kmArray);

    }

    public int getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(int carModelId) {
        this.carModelId = carModelId;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String type) {
        this.modelType = type;
    }

    public String getEndLeasing() {
        return endLeasing;
    }

    public void setEndLeasing(String endLeasing) {
        this.endLeasing = endLeasing;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public OwnerDetailViewModel getOwnerDetails() {
        return ownerDetails;
    }

    public void setOwnerDetails(OwnerDetailViewModel ownerDetails) {
        this.ownerDetails = ownerDetails;
    }

    public int getKmNeg() {
        return kmNeg;
    }

    public void setKmNeg(int kmNeg) {
        this.kmNeg = kmNeg;
    }

    public String getKmPercentNeg() {
        return kmPercentNeg;
    }

    public void setKmPercentNeg(String kmPercentNeg) {
        this.kmPercentNeg = kmPercentNeg;
    }

    public String getKmPercent() {
        return kmPercent;
    }

    public void setKmPercent(String kmPercent) {
        this.kmPercent = kmPercent;
    }

    public String getMark() {
        return mark;
    }

    public String calcPercent(int km)
    {
        float res = (km*100.0f)/160000;
        return String.format("%.0f", res)+"%";
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLeasingdate() {
        return leasingdate;
    }

    public void setLeasingdate(String leasingdate) {
        this.leasingdate = leasingdate;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer[] getKmArray() {
        return kmArray;
    }

    public void setKmArray(Integer[] kmArray) {
        this.kmArray = kmArray;
    }
}