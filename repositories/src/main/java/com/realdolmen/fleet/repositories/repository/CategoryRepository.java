package com.realdolmen.fleet.repositories.repository;

import com.realdolmen.fleet.model.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findByCategoryClass(int categoryClass);
}
