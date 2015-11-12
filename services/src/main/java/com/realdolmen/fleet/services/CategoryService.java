package com.realdolmen.fleet.services;

import com.realdolmen.fleet.model.domain.Category;
import com.realdolmen.fleet.repositories.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by SVCAX33 on 12/11/2015.
 */

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category findByCategoryClass(Integer categoryClass){
        Optional<Category> category = categoryRepository.findByCategoryClass(categoryClass);
        if(category.isPresent()){
            return category.get();
        }
        return null;
    }

}
