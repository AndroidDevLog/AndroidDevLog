package com.iosdevlog.a209googlemapwithzoomingcontrolsandsetviews;

import android.os.Bundle;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class MainActivity extends MapActivity {
    MapView mapView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapView = (MapView) findViewById(R.id.mapView);

        mapView.setBuiltInZoomControls(true);

        mapView.setSatellite(true);

        //	mapView.setStreetView(true);

    }

    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}