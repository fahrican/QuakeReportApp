package com.example.android.quakereport;

import static com.example.android.quakereport.R.id.date;

/**
 * Created by fahri on 17.10.17.
 */

public class Earthquake {

    private double magnitude;
    private String location;
    private long time;

    public Earthquake(double magnitude, String city, long date) {

        this.magnitude = magnitude;
        this.location = city;
        this.time = date;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long getTime() {
        return time;
    }
}
