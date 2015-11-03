package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.*;
import com.realdolmen.fleet.repositories.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by SVCAX33 on 2/11/2015.
 */


public class EmployeePageViewModel {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String username;
    private String businessUnit;
    private int phoneNumber;
    private String email;
    private Date birthDate;
    private String role;
    private Category userCategory;
    private int optionPackId;
    private String name;
    private int carId;
    private String color;
    private int kilometers;
    private String licensePlate;
    private Car car;
    private CarModel carModel;
    private int carModelId;
    private int horsePower;
    private int cilinder;
    private int motorType;
    private int gears;
    private int emission;
    private String line;
    private String model;
    private String mark;
    private Category carCategory;
    List<OptionPack> optionPacks;
    private CurrentCar currentCar;


    public EmployeePageViewModel(Employee employee) {
        this.employeeId = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.businessUnit = employee.getBusinessUnit();
        this.phoneNumber = employee.getPhoneNumber();
        this.username = employee.getUsername();
        this.email = employee.getEmail();
        this.birthDate = employee.getBirthDate();
        this.role = employee.getRole();
        this.userCategory = employee.getCategory();
        this.currentCar = employee.getCurrentCar();
        if(currentCar != null){
            this.car = currentCar.getCar();
            this.optionPacks = car.getOptionPacks();
            this.carId = car.getId();
            this.color = car.getColor();
            this.kilometers = car.getKilometers();
            this.licensePlate = car.getLicensePlate();
            this.carModel = car.getCarModel();
            this.horsePower = carModel.getHorsePower();
            this.cilinder = carModel.getCilinder();
            this.motorType = carModel.getMotorType();
            this.gears = carModel.getGears();
            this.emission = carModel.getEmission();
            this.line = carModel.getLine();
            this.model = carModel.getModel();
            this.mark = carModel.getMark();
            this.carCategory = carModel.getCategory();
        }
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Category getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(Category userCategory) {
        this.userCategory = userCategory;
    }

    public int getOptionPackId() {
        return optionPackId;
    }

    public void setOptionPackId(int optionPackId) {
        this.optionPackId = optionPackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
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

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public int getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(int carModelId) {
        this.carModelId = carModelId;
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

    public Category getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(Category carCategory) {
        this.carCategory = carCategory;
    }

    public List<OptionPack> getOptionPacks() {
        return optionPacks;
    }

    public void setOptionPacks(List<OptionPack> optionPacks) {
        this.optionPacks = optionPacks;
    }

    public CurrentCar getCurrentCar() {
        return currentCar;
    }

    public void setCurrentCar(CurrentCar currentCar) {
        this.currentCar = currentCar;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
