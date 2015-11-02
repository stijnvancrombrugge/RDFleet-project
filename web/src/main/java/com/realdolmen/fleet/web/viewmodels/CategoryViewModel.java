package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.domain.Category;

/**
 * Created by SVCAX33 on 2/11/2015.
 */
public class CategoryViewModel {

    private int id;
    private int categoryClass;

    public CategoryViewModel(Category category){
        this.id = category.getId();
        this.categoryClass = category.getCategoryClass();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryClass() {
        return categoryClass;
    }

    public void setCategoryClass(int categoryClass) {
        this.categoryClass = categoryClass;
    }
}
