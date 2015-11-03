package com.realdolmen.fleet.repositories.repository;


import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.Car;
import com.realdolmen.fleet.model.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by SDOAX36 on 30/10/2015.
 */
public interface CarModelRepository extends JpaRepository<CarModel, Integer> {

    List<CarModel> findByMarkAndCategory(String mark,Category category);

    List<CarModel> findByCategory(Category category);
}
