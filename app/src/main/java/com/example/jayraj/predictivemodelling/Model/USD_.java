package com.example.jayraj.predictive__model.Model;

import com.google.gson.annotations.Expose;

public class USD_ {

    @Expose
    private String PRICE;

    @Expose
    private String HIGHDAY;
    @Expose
    private String LOWDAY;

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String pRICE) {
        this.PRICE = pRICE;
    }


    public String getHIGHDAY() {
        return HIGHDAY;
    }

    public void setHIGHDAY(String hIGHDAY) {
        this.HIGHDAY = hIGHDAY;
    }

    public String getLOWDAY() {
        return LOWDAY;
    }

    public void setLOWDAY(String lOWDAY) {
        this.LOWDAY = lOWDAY;
    }


}
