package com.app.countriesapp.ux.model;

import java.io.Serializable;

public class SwitzerlandModel implements Serializable {
    private String switzerlandImage;
    private String switzerlandName;

    public SwitzerlandModel(String switzerlandImage, String switzerlandName) {
        this.switzerlandImage = switzerlandImage;
        this.switzerlandName = switzerlandName;
    }
    public SwitzerlandModel(){

    }

    public String getSwitzerlandImage() {
        return switzerlandImage;
    }

    public void setSwitzerlandImage(String switzerlandImage) {
        this.switzerlandImage = switzerlandImage;
    }

    public String getSwitzerlandName() {
        return switzerlandName;
    }

    public void setSwitzerlandName(String setSwitzerlandName) {
        this.switzerlandName = switzerlandName;
    }
}
