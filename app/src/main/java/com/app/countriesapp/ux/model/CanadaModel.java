package com.app.countriesapp.ux.model;

import java.io.Serializable;

public class CanadaModel implements Serializable {
    private String canadaImage;
    private String canadaName;

    public CanadaModel(String canadaImage, String canadaName) {
        this.canadaImage = canadaImage;
        this.canadaName = canadaName;
    }
    public CanadaModel(){

    }

    public String getCanadaImage() {
        return canadaImage;
    }

    public void setCanadaImage(String canadaImage) {
        this.canadaImage = canadaImage;
    }

    public String getCanadaName() {
        return canadaName;
    }

    public void setCanadaName(String canadaName) {
        this.canadaName = canadaName;
    }
}

