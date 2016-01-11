package com.example.elise.rozenbergearthquakes;

import java.io.Serializable;
import java.net.URL;
import java.util.Date;

/**
 * Created by Elise on 12/3/2015.
 */
public class Properties implements Serializable {
    private String title;
    private long time;

    public String getTitle() {
        return title;
    }

    public String getTime() {
        Date date = new Date(time);
        return date.toString();
    }
}