package com.iosdevlog.a8file;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private File file;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
    }

    // Load
    public void load(View view) {

        String filename = getString(R.string.filename);
        FileInputStream inputStream;

        try {
            inputStream = openFileInput(filename);
            byte[] b=new byte[inputStream.available()];//新建一个字节数组
            inputStream.read(b);//将文件中的内容读取到字节数组中
            inputStream.close();
            editText.setText(new String(b));//再将字节数组中的内容转化成字符串形式输出
            Toast.makeText(MainActivity.this, "Load Done!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Load Error!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    // Save
    public void save(View view) {
        // internal
        String filename = getString(R.string.filename);
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            String string = editText.getText().toString();
            outputStream.write(string.getBytes());
            outputStream.close();
            Toast.makeText(MainActivity.this, "Save Done!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "Save Error!", Toast.LENGTH_SHORT).show();
        }
    }

    // Delete
    public void delete(View view) {
        String filename = getString(R.string.filename);
        try {
            this.deleteFile(filename);
            Toast.makeText(MainActivity.this, "Delete Done!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Delete Error!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    public File getAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e(TAG, "Directory not created");
        }
        return file;
    }

    public File getAlbumStorageDir(Context context, String albumName) {
        // Get the directory for the app's private pictures directory.
        File file = new File(context.getExternalFilesDir(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e(TAG, "Directory not created");
        }
        return file;
    }
}
