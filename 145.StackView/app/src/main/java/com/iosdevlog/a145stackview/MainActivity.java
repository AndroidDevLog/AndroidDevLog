package com.iosdevlog.a145stackview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.StackView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StackView stk = (StackView) this.findViewById(R.id.stackView1);

        ArrayList<StackItem> items = new ArrayList<StackItem>();
        items.add(new StackItem("text1", this.getResources().getDrawable(R.drawable.android)));
        items.add(new StackItem("text2", this.getResources().getDrawable(R.drawable.android)));
        items.add(new StackItem("text3", this.getResources().getDrawable(R.drawable.android)));
        items.add(new StackItem("text4", this.getResources().getDrawable(R.drawable.android)));
        items.add(new StackItem("text5", this.getResources().getDrawable(R.drawable.android)));

        StackAdapter adapt = new StackAdapter(this, R.layout.item, items);

        stk.setAdapter(adapt);
    }
}
