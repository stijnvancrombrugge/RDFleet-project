package com.realdolmen.fleet.repositories.repository;

import com.realdolmen.fleet.model.domain.Car;
import com.realdolmen.fleet.model.domain.CurrentCar;
import com.realdolmen.fleet.model.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by SDOAX36 on 3/11/2015.
 */
public interface CurrentCarRepository extends JpaRepository<CurrentCar,Integer> {

    @Query("Select c from CurrentCar c where c.car.carModel.mark like :mark")
    public List<CurrentCar>findCurrentCarByCarCarModelMark(@Param("mark")String mark);

    @Query("select count(c) from CurrentCar c where c.car.carModel.model like :model")
    public Integer findCountByModel(@Param("model")String model);

    public List<CurrentCar>findByEmployeeIsNull();

    public List<CurrentCar>findByEmployeeIsNotNull();

    public List<CurrentCar>findByCarCarModelMarkAndEmployeeIsNull(String mark);

    public List<CurrentCar>findByCarCarModelMarkAndEmployeeIsNotNull(String mark);

    public List<CurrentCar>findByCarCarModelModelAndEmployeeIsNull(String model);

    public List<CurrentCar>findByCarCarModelModelAndEmployeeIsNotNull(String model);

    public Optional<CurrentCar> findByCar(Car car);

    /**
     *
     * @param mark
     * @param model
     * @param color
     * @return Optional
     select c from CurrentCar c where c.car.carModel.mark like :mark
     and c.car.carModel.model like :model
     and c.car.color like :color
     and c.employee is null
     */
    public List<CurrentCar>findByCarCarModelMarkAndCarCarModelModelAndCarColorAndEmployeeIsNull(String mark,String model,String color);


}
