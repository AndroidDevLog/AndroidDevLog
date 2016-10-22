package com.iosdevlog.a219bindanactivitytoaservice;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.net.URL;

/**
 * Created by iosdevlog on 2016/10/22.
 */

public class MyService extends Service {
    int counter = 0;
    URL[] urls;

    static final int UPDATE_INTERVAL = 1000;

    private final IBinder binder = new MyBinder();

    public class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        new DoBackgroundTask().execute(urls);

        return START_STICKY;
    }

    private int DownloadFile(URL url) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return 100;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(getBaseContext(), "Service Destroyed",
                Toast.LENGTH_SHORT).show();
    }

    private class DoBackgroundTask extends AsyncTask<URL, Integer, Long> {
        protected Long doInBackground(URL... urls) {
            int count = urls.length;
            long totalBytesDownloaded = 0;
            for (int i = 0; i < count; i++) {
                totalBytesDownloaded += DownloadFile(urls[i]);
                //---calculate percentage downloaded and
                // report its progress---
                publishProgress((int) (((i + 1) / (float) count) * 100));
            }
            return totalBytesDownloaded;
        }

        protected void onProgressUpdate(Integer... progress) {

            Log.d("Downloading files", String.valueOf(progress[0])
                    + "% downloaded");

            Toast.makeText(getBaseContext(), String.valueOf(progress[0])
                    + "% downloaded", Toast.LENGTH_LONG).show();
        }

        protected void onPostExecute(Long result) {

            Toast.makeText(getBaseContext(), "Downloaded " + result + " bytes",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        }
    }
}
