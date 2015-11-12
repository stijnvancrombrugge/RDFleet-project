package com.realdolmen.fleet.services;

import com.realdolmen.fleet.model.Models.CarModel;
import com.realdolmen.fleet.model.domain.Category;
import com.realdolmen.fleet.repositories.repository.CarModelRepository;
import com.realdolmen.fleet.repositories.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SVCAX33 on 3/11/2015.
 */

@Service
public class CarModelService {

    @Autowired
    public CarModelRepository carModelRepository;

    @Autowired
    public CategoryRepository categoryRepository;


   public List<CarModel> findAll(){
       return carModelRepository.findAll();
   }

    public List<CarModel> findByMarkAndCategory(String mark, Integer categoryClass){

        Category category = null;
        if(categoryRepository.findByCategoryClass(categoryClass).isPresent()){
            category = categoryRepository.findByCategoryClass(categoryClass).get();
        }
        return carModelRepository.findByMarkAndCategory(mark, category);
    }

    public CarModel findById(Integer id){
        return carModelRepository.findOne(id);
    }

    public byte[] findImageByCarModelId(Integer id){
        return carModelRepository.findOne(id).getImage();
    }

    public CarModel saveNewModel(CarModel carModel)
    {
        carModelRepository.saveAndFlush(carModel);
        return carModel;
    }

    public void changeCarModelCategory(Integer carModelId, Integer category){
        Category newCategory;
        if(categoryRepository.findByCategoryClass(category).isPresent()){
           newCategory = categoryRepository.findByCategoryClass(category).get();
        }
        else{
            newCategory = new Category(category);
            categoryRepository.save(newCategory);
        }
        CarModel carModel = carModelRepository.findOne(carModelId);
        carModel.setCategory(newCategory);
        carModelRepository.saveAndFlush(carModel);
    }
}
