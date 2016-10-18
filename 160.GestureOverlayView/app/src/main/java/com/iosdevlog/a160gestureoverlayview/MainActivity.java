package com.iosdevlog.a160gestureoverlayview;

import android.Manifest;
import android.app.ListActivity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.os.Build;
import android.os.Bundle;
import android.provider.Contacts;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity implements OnGesturePerformedListener {
    GestureLibrary lib;
    // Request code for READ_CONTACTS. It can be any number > 0.
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // http://stackoverflow.com/questions/29915919/permission-denial-opening-provider-com-android-providers-contacts-contactsprovi
        // Read and show the contacts
        showContacts();
    }

    /**
     * Show the contacts in the ListView.
     */
    private void showContacts() {
        // Check the SDK version and whether the permission is already granted or not.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        } else {
            // Android version is lesser than 6.0 or the permission is already granted.

            Cursor query = managedQuery(Contacts.People.CONTENT_URI,
                    new String[]{Contacts.People._ID, Contacts.People.DISPLAY_NAME},
                    null, null, Contacts.People.DEFAULT_SORT_ORDER);

            ListAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1, query,
                    new String[]{Contacts.People.DISPLAY_NAME},
                    new int[]{android.R.id.text1});

            setListAdapter(adapter);

            lib = GestureLibraries.fromRawResource(this, R.raw.actions);
            if (!lib.load()) {
                finish();
            }

            GestureOverlayView gesture = (GestureOverlayView)
                    findViewById(R.id.gestures);

            gesture.addOnGesturePerformedListener(this);
        }
    }

    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        ArrayList<Prediction> predictions = lib.recognize(gesture);

        if (predictions.size() > 0) {
            if (predictions.get(0).score > 1.0) {
                String action = predictions.get(0).name;

                if ("action_add".equals(action)) {
                    Toast.makeText(this, "Adding a contact",
                            Toast.LENGTH_SHORT).show();

                } else if ("action_delete".equals(action)) {
                    Toast.makeText(this, "Removing a contact",
                            Toast.LENGTH_SHORT).show();

                } else if ("action_refresh".equals(action)) {
                    Toast.makeText(this, "Reloading contacts",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted
                showContacts();
            } else {
                Toast.makeText(this, "Until you grant the permission, we canot display the names", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
