package com.iosdevlog.a121customarrayadapterinlistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    static final String[] Android =
            new String[]{"CupCake", "Donut", "Froyo", "GingerBread",
                    "HoneyComb", "Ice-Cream Sandwich", "Jelly-Bean"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ListAct(this, Android));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String selectedValue = (String) getListAdapter().getItem(position);
        Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
    }
}
