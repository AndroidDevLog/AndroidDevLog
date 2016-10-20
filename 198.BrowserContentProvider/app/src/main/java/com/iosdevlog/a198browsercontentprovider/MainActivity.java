package com.iosdevlog.a198browsercontentprovider;

import android.os.Bundle;
import android.provider.Browser;
import android.app.ListActivity;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {
    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cursor cursor = getContentResolver().query
                (Browser.BOOKMARKS_URI, null, null, null, null);

        String s[] = new String[]{
                Browser.BookmarkColumns.BOOKMARK,
                Browser.BookmarkColumns.TITLE};
        int view[] = new int[]{
                R.id.BookMark, R.id.Title};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter
                (this, R.layout.activity_main, cursor, s, view);
        this.setListAdapter(adapter);
    }
}
