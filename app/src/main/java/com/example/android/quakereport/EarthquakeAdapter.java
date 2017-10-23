package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.DecimalFormat;
import java.util.List;

import android.graphics.drawable.GradientDrawable;


import static android.R.attr.breakStrategy;
import static android.R.attr.resource;

/**
 * Created by fahri on 17.10.17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Activity context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake eq = getItem(position);

        DecimalFormat formatter = new DecimalFormat("0.0");
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeTextView.setText(formatter.format(eq.getMagnitude()));

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(eq.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        String originalLocation = eq.getLocation();
        String primaryLocation;
        String locationOffset;

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        //get distance of the earthquake for instance 74km NW of
        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);

        //get distance of the earthquake for instance Rumoi, Japan
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);


        Date dateObject = new Date(eq.getTime());


        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateTextView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);


        // Return the whole list item layout
        // so that it can be shown in the ListView
        return listItemView;

    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    //returns the correct background color for each magnitude
    private int getMagnitudeColor(double magnitude) {

        int magnitudeColor;
        int magnitudeFloor = (int) Math.floor(magnitude);

        switch (magnitudeFloor) {

            case 0:
            case 1:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;

            case 2:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;

            case 3:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;

            case 4:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;

            case 5:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;

            case 6:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;

            case 7:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;

            case 8:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;

            case 9:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;

            default:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }
        return magnitudeColor;
    }
}
