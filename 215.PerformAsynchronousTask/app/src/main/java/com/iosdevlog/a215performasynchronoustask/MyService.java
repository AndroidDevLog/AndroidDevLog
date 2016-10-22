package com.iosdevlog.a215performasynchronoustask;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by iosdevlog on 2016/10/22.
 */

public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getBaseContext(), "Service Started",
                Toast.LENGTH_SHORT).show();

        try {
            new DoBackgroundTask().execute(
                    new URL("http://iosdevlog.com/assets/images/Android/AndroidDevLog/1/basic-lifecycle.png"),
                    new URL("http://iosdevlog.com/assets/images/Android/AndroidDevLog/1/basic-lifecycle.png"),
                    new URL("http://iosdevlog.com/assets/images/Android/AndroidDevLog/1/basic-lifecycle.png"),
                    new URL("http://iosdevlog.com/assets/images/Android/AndroidDevLog/1/basic-lifecycle.png"),
                    new URL("http://iosdevlog.com/assets/images/Android/AndroidDevLog/1/basic-lifecycle.png"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

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
            Log.d("Downloading files",
                    String.valueOf(progress[0]) + "% downloaded");
            Toast.makeText(getBaseContext(), String.valueOf(progress[0]) +
                    "% downloaded", Toast.LENGTH_LONG).show();
        }

        protected void onPostExecute(Long result) {
            Toast.makeText(getBaseContext(), "Downloaded " + result + " bytes",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        }
    }
}
