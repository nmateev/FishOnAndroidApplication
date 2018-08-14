package com.mateev.fishon.models;

public class Location  {

    public String countryName;
    public String waterBasinName;
    public String waterBasinType;

    public Location() {
        // Required empty public constructor
    }

    public Location(String countryName, String waterBasinName, String waterBasinType) {
        setCountry(countryName);
        setWaterBasinName(waterBasinName);
        setWaterBasinType(waterBasinType);
    }

    public String getCountry() {
        return countryName;
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

    private void setCountry(String countryName) {
        this.countryName = countryName;
    }

    private void setWaterBasinType(String waterBasinType) {
        this.waterBasinType = waterBasinType;
    }
}
