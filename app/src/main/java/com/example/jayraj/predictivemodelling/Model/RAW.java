package com.example.jayraj.predictive__model.Model;

import com.google.gson.annotations.Expose;

public class RAW {

    @Expose
    private BTC BTC;

    public BTC getBTC() {
        return BTC;
    }

    public void setBTC(BTC bTC) {
        this.BTC = bTC;
    }
}
