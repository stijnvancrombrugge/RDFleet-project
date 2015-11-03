package com.realdolmen.fleet.model.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by SDOAX36 on 28/10/2015.
 */
@Entity
@Table(name = "options")
public class Option extends AbstractEntity{


    @NotNull
    @Size(min=1,max = 50)
    private String optionName;

    private Integer amount;

    private Integer price;
    //other variables


    public Option() {
    }

    public Option(String optionName) {
        this.optionName = optionName;
    }


    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
