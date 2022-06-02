package com.app.countriesapp.ui.model;

public class AmericaModel {

    private String americaImage;
    private String americaName;

    public AmericaModel(String americaImage, String americaName) {
        this.americaImage = americaImage;
        this.americaName = americaName;
    }

    public String getAmericaImage() {
        return americaImage;
    }

    public void setAmericaImage(String americaImage) {
        this.americaImage = americaImage;
    }

    public String getAmericaName() {
        return americaName;
    }

    public void setAmericaName(String americaName) {
        this.americaName = americaName;
    }
}
