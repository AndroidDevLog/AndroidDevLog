package com.iosdevlog.a197contentprovider;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri allContacts = Uri.parse("content://contacts/people");
        Cursor c = managedQuery(allContacts, null, null, null, null);

        String[] columns = new String[] {
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts._ID };

        int[] views = new int[] {R.id.contactName, R.id.contactID };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter
                (this, R.layout.activity_main, c, columns, views);
        this.setListAdapter(adapter);
    }

}
