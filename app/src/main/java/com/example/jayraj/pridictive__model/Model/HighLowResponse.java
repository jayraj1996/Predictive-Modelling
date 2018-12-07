package com.example.jayraj.pridictive__model.Model;

import com.google.gson.annotations.Expose;

public class HighLowResponse {

    @Expose
    private RAW RAW;
    @Expose
    private DISPLAY DISPLAY;

    public RAW getRAW() {
        return RAW;
    }

    public void setRAW(RAW rAW) {
        this.RAW = rAW;
    }

    public DISPLAY getDISPLAY() {
        return DISPLAY;
    }

    public void setDISPLAY(DISPLAY dISPLAY) {
        this.DISPLAY = dISPLAY;
    }

}
