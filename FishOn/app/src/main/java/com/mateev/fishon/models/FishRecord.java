package com.mateev.fishon.models;

import java.io.Serializable;

public class FishRecord implements Serializable {

    public String speciesName;
    public String yearCaught;
    public String countryCaught;
    public double weight;
    public double length;

    public FishRecord() {
        // Required empty public constructor
    }

    public FishRecord(String speciesName, String yearCaught, String countryCaught, double length, double weight) {
        setSpeciesName(speciesName);
        setYearCaught(yearCaught);
        setCountryCaught(countryCaught);
        setLength(length);
        setWeight(weight);
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public String getYearCaught() {
        return yearCaught;
    }

    public String getCountryCaught() {
        return countryCaught;
    }

    public double getWeight() {
        return weight;
    }

    public double getLength() {
        return length;
    }

    private void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    private void setYearCaught(String yearCaught) {
        this.yearCaught = yearCaught;
    }

    private void setCountryCaught(String countryCaught) {
        this.countryCaught = countryCaught;
    }

    private void setWeight(double weight) {
        this.weight = weight;
    }

    private void setLength(double length) {
        this.length = length;
    }
}
