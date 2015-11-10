package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.Car;
import com.realdolmen.fleet.model.domain.Employee;
import com.realdolmen.fleet.model.domain.Order;
import com.realdolmen.fleet.model.domain.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SVCAX33 on 10/11/2015.
 */
public class EmployeeCarsViewModel {

    private CarModel currentCarModel;
    private Car currentCar;
    private int employeeId;
    private String employeeName;
    private List<Car> carHistory;

    public EmployeeCarsViewModel(Employee employee){
        this.employeeId = employee.getId();
        this.employeeName = employee.getFirstName() + " " + employee.getLastName();
        if(employee.getCurrentCar() != null) {
            this.currentCar = employee.getCurrentCar().getCar();
            this.currentCarModel = employee.getCurrentCar().getCar().getCarModel();
        }
        carHistory = new ArrayList<>();
        for(Order order: employee.getOrders()){
            if(order.getStatus() == Status.POOL){
                carHistory.add(order.getCar());
            }
        };
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Car getCurrentCar() {
        return currentCar;
    }

    public void setCurrentCar(Car currentCar) {
        this.currentCar = currentCar;
    }

    public List<Car> getCarHistory() {
        return carHistory;
    }

    public void setCarHistory(List<Car> carHistory) {
        this.carHistory = carHistory;
    }

    public CarModel getCurrentCarModel() {
        return currentCarModel;
    }

    public void setCurrentCarModel(CarModel currentCarModel) {
        this.currentCarModel = currentCarModel;
    }
}
