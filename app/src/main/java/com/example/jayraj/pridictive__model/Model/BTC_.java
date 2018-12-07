package com.example.jayraj.pridictive__model.Model;

import com.google.gson.annotations.Expose;

public class BTC_ {

    @Expose
    private USD_ USD;

    public USD_ getUSD() {
        return USD;
    }

    public void setUSD(USD_ uSD) {
        this.USD = uSD;
    }
}
