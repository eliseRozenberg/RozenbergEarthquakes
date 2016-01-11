package com.example.elise.rozenbergearthquakes;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Elise on 12/4/2015.
 */
public class EarthquakeAsyncTask extends AsyncTask<Long, Earthquakes, Earthquakes> {
    private Earthquakes earthquakes;
    private RecyclerView recyclerView;
    private EarthquakeAdapter adapter;

    public EarthquakeAsyncTask(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    protected Earthquakes doInBackground(Long... params) {
        URL url = null;
        Gson gson = new Gson();
        InputStream in = null;
        try {
            url = new URL("http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/significant_month.geojson");
            in = url.openConnection().getInputStream();
            earthquakes = gson.fromJson(new InputStreamReader(in), Earthquakes.class);
            return earthquakes;
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        earthquakes = gson.fromJson(new InputStreamReader(in), Earthquakes.class);
        return earthquakes;
    }

    @Override
    protected void onPostExecute(Earthquakes earthquakes) {
        super.onPostExecute(earthquakes);
        adapter = new EarthquakeAdapter(earthquakes.getFeatures());
        recyclerView.setAdapter(adapter);
    }
}
