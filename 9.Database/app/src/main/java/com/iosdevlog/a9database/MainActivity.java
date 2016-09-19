package com.iosdevlog.a9database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FeedReaderDbHelper mDbHelper;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDbHelper = new FeedReaderDbHelper(this);
        editText = (EditText)findViewById(R.id.editText);
    }

    public void insert(View view) {
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, "title");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, "subTitle");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_CONTENT, "content");

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FeedReaderContract.FeedEntry.TABLE_NAME,
                null,
                values);

        Toast.makeText(MainActivity.this, String.valueOf(newRowId), Toast.LENGTH_SHORT).show();

        editText.setText(editText.getText().toString() + values.toString() + "\n\n");
    }

    public void retrieve(View view) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                FeedReaderContract.FeedEntry._ID,
                FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE,
                FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE,
                FeedReaderContract.FeedEntry.COLUMN_NAME_CONTENT,
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                FeedReaderContract.FeedEntry._ID + " DESC";

        Cursor cursor = db.query(
                FeedReaderContract.FeedEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,                                     // The columns for the WHERE clause
                null,                                     // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        cursor.moveToFirst();

        if (cursor!=null) {
            while (cursor.moveToNext()) {
                int _id = cursor.getInt(cursor.getColumnIndex(FeedReaderContract.FeedEntry._ID));
                String title = cursor.getString(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE));
                String subtitle = cursor.getString(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE));

                String contract = "_id=>" + _id + ", title=>" + title + ", subtitle=>" + subtitle;
                Log.i("db", contract);
                Toast.makeText(MainActivity.this, contract, Toast.LENGTH_SHORT).show();

                editText.setText(editText.getText().toString() + contract + "\n");
            }
            editText.setText(editText.getText().toString() + "\n");
        } else {
            Toast.makeText(MainActivity.this, "Null", Toast.LENGTH_SHORT).show();
        }
    }
}
