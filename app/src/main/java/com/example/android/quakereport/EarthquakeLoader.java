package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by fahri on 23.10.17.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    /** Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /** Query URL */
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        // TODO: Finish implementing this constructor
        this.mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        // TODO: Implement this method
        // Don't perform the request if there are no URLs, or the first URL is null.
        if (mUrl == null) {
            return null;
        }

        List<Earthquake> result = QueryUtils.fetchEarthquakeData(mUrl);
        return result;
    }
}