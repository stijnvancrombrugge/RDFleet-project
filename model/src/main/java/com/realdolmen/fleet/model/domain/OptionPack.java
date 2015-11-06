package com.realdolmen.fleet.model.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
@Entity
public class OptionPack extends AbstractEntity {


    @NotNull
    @Column(length = 100)
    @Size(min = 1, max = 100)
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Option> options;

    private boolean chosen;

    public OptionPack(String name) {
        this.name = name;
        this.options = new ArrayList<>();
    }

    public OptionPack() {
        this.options = new ArrayList<>();
    }

    public void addOption(Option option)
    {
        options.add(option);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public boolean isChosen() {
        return chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }
}
