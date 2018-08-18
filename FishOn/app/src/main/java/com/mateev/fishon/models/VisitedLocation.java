package com.mateev.fishon.models;


//created for firebase collection purposes
public class VisitedLocation extends Location {

    VisitedLocation() {

    }

    public VisitedLocation(String countryName, String waterBasinName, String waterBasinType) {
        super(countryName, waterBasinName, waterBasinType);
    }
}
