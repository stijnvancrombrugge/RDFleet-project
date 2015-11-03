package com.realdolmen.fleet.repositories.repository;

import com.realdolmen.fleet.model.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findByCategoryClass(int categoryClass);
}
