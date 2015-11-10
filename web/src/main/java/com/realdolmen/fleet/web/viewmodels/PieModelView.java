package com.realdolmen.fleet.web.viewmodels;

/**
 * Created by SDOAX36 on 9/11/2015.
 */
public class PieModelView{

    private String color;
    private int value;

    public PieModelView(String color, int value)
    {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
