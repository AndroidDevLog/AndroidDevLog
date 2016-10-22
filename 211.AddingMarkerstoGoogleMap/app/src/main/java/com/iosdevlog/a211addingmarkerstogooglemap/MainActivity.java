package com.iosdevlog.a211addingmarkerstogooglemap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.view.KeyEvent;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

import java.util.List;

public class MainActivity extends MapActivity {
    MapView mapView;
    MapController mc;
    GeoPoint point;

    class MapOverlay extends com.google.android.maps.Overlay {
        @Override
        public boolean draw(Canvas canvas, MapView mapView, boolean shadow, long when) {
            super.draw(canvas, mapView, shadow);
            //---translate the GeoPoint to screen pixels---
            Point screenPts = new Point();
            mapView.getProjection().toPixels(point, screenPts);
            //---add the marker---
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.android);
            canvas.drawBitmap(bmp, screenPts.x, screenPts.y - 50, null);
            return true;
        }
    }

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

        //---Add a location marker---
        MapOverlay mapOverlay = new MapOverlay();
        List<Overlay> listOfOverlays = mapView.getOverlays();
        listOfOverlays.clear();
        listOfOverlays.add(mapOverlay);

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
