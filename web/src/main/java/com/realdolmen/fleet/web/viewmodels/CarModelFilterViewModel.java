package com.realdolmen.fleet.web.viewmodels;

import javax.validation.constraints.NotNull;

/**
 * Created by SVCAX33 on 9/11/2015.
 */
public class CarModelFilterViewModel {

    @NotNull
    private int category;

    @NotNull
    private String mark;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
