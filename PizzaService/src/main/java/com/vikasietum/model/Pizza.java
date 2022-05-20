package com.vikasietum.model;

public class Pizza {
    private String name;
    private String size;


    private Double smallPrice;                            // cost of small size pizza
    private Double mediumPrice;                            // cost of small size pizza
    private Double largePrice;                            // cost of small size pizza
    private boolean veg;                             // type of pizza non veg(0) or veg(1)

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getSmallPrice() {
        return smallPrice;
    }

    public void setSmallPrice(Double smallPrice) {
        this.smallPrice = smallPrice;
    }

    public Double getMediumPrice() {
        return mediumPrice;
    }

    public void setMediumPrice(Double mediumPrice) {
        this.mediumPrice = mediumPrice;
    }

    public Double getLargePrice() {
        return largePrice;
    }

    public void setLargePrice(Double largePrice) {
        this.largePrice = largePrice;
    }

    public boolean isVeg() {
        return veg;
    }

    public void setVeg(boolean veg) {
        this.veg = veg;
    }

    public void setName(String name) {
        this.name = name;
    }
}
