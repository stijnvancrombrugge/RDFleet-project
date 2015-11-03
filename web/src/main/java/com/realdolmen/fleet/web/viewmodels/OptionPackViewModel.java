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
    List<Option> optionList;

    public OptionPackViewModel(OptionPack optionPack){
        this.id = optionPack.getId();
        this.name = optionPack.getName();
        this.optionList = new ArrayList<>();
        for(Option option: optionPack.getOptions()){
            optionList.add(option);
        }
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

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }
}
