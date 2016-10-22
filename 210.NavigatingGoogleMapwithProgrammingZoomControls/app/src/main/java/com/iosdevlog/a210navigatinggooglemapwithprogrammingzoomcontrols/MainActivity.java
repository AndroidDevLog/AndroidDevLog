package com.iosdevlog.a210navigatinggooglemapwithprogrammingzoomcontrols;

import android.os.Bundle;
import android.view.KeyEvent;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;


public class MainActivity extends MapActivity {
    MapView mapView;
    MapController mc;
    GeoPoint point;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.setBuiltInZoomControls(true);

        //	mapView.setSatellite(true);

        mapView.setStreetView(true);

        mc = mapView.getController();
        String coordinates[] = {"1.352566007", "103.78921587"};
        double lat = Double.parseDouble(coordinates[0]);
        double lng = Double.parseDouble(coordinates[1]);
        point = new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6));
        mc.animateTo(point);
        mc.setZoom(12);
        mapView.invalidate();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        MapController mc = mapView.getController();
        switch (keyCode) {
            case KeyEvent.KEYCODE_3:
                mc.zoomIn();
                break;
            case KeyEvent.KEYCODE_1:
                mc.zoomOut();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}