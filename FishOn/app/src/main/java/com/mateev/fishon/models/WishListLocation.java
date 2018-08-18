package com.mateev.fishon.models;

//created for firebase collection purposes
public class WishListLocation extends Location {


    public WishListLocation() {
        // Required empty public constructor
    }

    public WishListLocation(String countryName, String waterBasinName, String waterBasinType) {
        super(countryName, waterBasinName, waterBasinType);
    }

}
