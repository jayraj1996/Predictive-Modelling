package com.example.jayraj.pridictive__model.Model;

import com.google.gson.annotations.Expose;

public class USD {

    @Expose
    private Double PRICE;
    @Expose
    private Double HIGHDAY;
    @Expose
    private Double LOWDAY;


    public Double getPRICE() {
        return PRICE;
    }

    public void setPRICE(Double pRICE) {
        this.PRICE = pRICE;
    }


    public Double getHIGHDAY() {
        return HIGHDAY;
    }

    public void setHIGHDAY(Double hIGHDAY) {
        this.HIGHDAY = hIGHDAY;
    }

    public Double getLOWDAY() {
        return LOWDAY;
    }

    public void setLOWDAY(Double lOWDAY) {
        this.LOWDAY = lOWDAY;
    }



}
