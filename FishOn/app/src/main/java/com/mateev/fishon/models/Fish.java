package com.mateev.fishon.models;

import java.io.Serializable;

public class Fish implements Serializable {

    public String speciesName;
    public String yearCaught;
    public String country;
    public double weight;
    public double length;

    public Fish() {

    }

    public Fish(String speciesName, String yearCaught, String country, double length, double weight) {
        setSpeciesName(speciesName);
        setYearCaught(yearCaught);
        setCountry(country);
        setLength(length);
        setWeight(weight);
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public String getYearCaught() {
        return yearCaught;
    }

    public String getCountry() {
        return country;
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

    private void setCountry(String country) {
        this.country = country;
    }

    private void setWeight(double weight) {
        this.weight = weight;
    }

    private void setLength(double length) {
        this.length = length;
    }
}
