package com.example.android.quakereport;

/**
 * Created by fahri on 17.10.17.
 */

public class Earthquake {

    private String magnitude;
    private String location;
    private String date;

    public Earthquake(String magnitude, String city, String date) {

        this.magnitude = magnitude;
        this.location = city;
        this.date = date;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
}
