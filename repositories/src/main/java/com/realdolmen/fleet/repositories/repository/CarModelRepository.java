package com.realdolmen.fleet.repositories.repository;


import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by SDOAX36 on 30/10/2015.
 */
public interface CarModelRepository extends JpaRepository<CarModel, Integer> {

    List<CarModel> findByMarkAndCategory(String mark,Integer category);

    List<CarModel> findByCategory(Integer category);
}
