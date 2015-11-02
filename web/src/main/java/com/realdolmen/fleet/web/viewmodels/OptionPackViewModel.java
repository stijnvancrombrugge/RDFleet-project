package com.realdolmen.fleet.web.viewmodels;

import com.realdolmen.fleet.model.domain.Option;
import com.realdolmen.fleet.model.domain.OptionPack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SVCAX33 on 2/11/2015.
 */
public class OptionPackViewModel {

    private int id;
    private String name;
    List<OptionViewModel> optionViewModelList;

    public OptionPackViewModel(OptionPack optionPack){
        this.id = optionPack.getId();
        this.name = optionPack.getName();
        this.optionViewModelList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OptionViewModel> getOptionViewModelList() {
        return optionViewModelList;
    }

    public void setOptionViewModelList(List<OptionViewModel> optionViewModelList) {
        this.optionViewModelList = optionViewModelList;
    }
}
