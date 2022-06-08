package com.app.countriesapp.ux.model;

import java.io.Serializable;

public class IranModel implements Serializable {
    private String iranImage;
    private String iranName;

    public IranModel(String iranImage, String iranName) {
        this.iranImage = iranImage;
        this.iranName = iranName;
    }
    public IranModel(){

    }

    public String getIranImage() {
        return iranImage;
    }

    public void setIranImage(String iranImage) {
        this.iranImage = iranImage;
    }

    public String getIranName() {
        return iranName;
    }

    public void setIranName(String iranName) {
        this.iranName = iranName;
    }
}