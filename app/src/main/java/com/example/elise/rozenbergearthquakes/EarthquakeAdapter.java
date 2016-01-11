package com.example.elise.rozenbergearthquakes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Elise on 12/3/2015.
 */
public class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeViewHolder> {
    private Features[] features;

    public EarthquakeAdapter(Features[] features) {
        this.features = features;
    }

    @Override
    public EarthquakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.earthquake_list, parent, false);
        return new EarthquakeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final EarthquakeViewHolder holder, final int position) {
        holder.bind(features[position]);
    }

    @Override
    public int getItemCount() {
        return features.length;
    }
}
