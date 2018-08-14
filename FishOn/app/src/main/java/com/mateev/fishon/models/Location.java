package com.mateev.fishon.models;

public class Location {

    public String country;
    public String waterBasinName;
    public String waterBasinType;

    public Location() {
        // Required empty public constructor
    }

    public Location(String country, String waterBasinName, String waterBasinType) {
        setCountry(country);
        setWaterBasinName(waterBasinName);
        setWaterBasinType(waterBasinType);
    }

    public String getCountry() {
        return country;
    }

    public String getWaterBasinName() {
        return waterBasinName;
    }

    public String getWaterBasinType() {
        return waterBasinType;
    }

    private void setWaterBasinName(String waterBasinName) {
        this.waterBasinName = waterBasinName;
    }

    private void setCountry(String country) {
        this.country = country;
    }

    private void setWaterBasinType(String waterBasinType) {
        this.waterBasinType = waterBasinType;
    }
}
