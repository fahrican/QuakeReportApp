package com.example.android.quakereport;

/**
 * Created by fahri on 17.10.17.
 */

public class Earthquake {

    private double magnitude;
    private String city;
    private String date;

    public Earthquake(double magnitude, String city, String date) {

        this.magnitude = magnitude;
        this.city = city;
        this.date = date;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }
}
