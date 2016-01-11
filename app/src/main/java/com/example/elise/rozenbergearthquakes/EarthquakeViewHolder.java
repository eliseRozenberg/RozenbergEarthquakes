package com.example.elise.rozenbergearthquakes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Elise on 12/3/2015.
 */
public class EarthquakeViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView time;

    public EarthquakeViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        time = (TextView) itemView.findViewById(R.id.time);
    }

    public void bind(Features feature) {
        title.setText(feature.getProperties().getTitle());
        time.setText(feature.getProperties().getTime() + "\n\n");
    }
}
