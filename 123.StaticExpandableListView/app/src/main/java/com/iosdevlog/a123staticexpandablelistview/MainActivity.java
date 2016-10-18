package com.iosdevlog.a123staticexpandablelistview;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ExpandableListActivity {
    private ExpandableListAdapter mAdapter;
    ExpandableListView expand;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Map<String, String>> groupData = new ArrayList<>();
        List<List<Map<String, String>>> childData = new ArrayList<>();

	/* ******************** Start Group  ********************* */
        Map<String, String> curgroupMap1 = new HashMap<>();
        groupData.add(curgroupMap1);
        curgroupMap1.put("parent", "Master 1");

        List<Map<String, String>> children1 = new ArrayList<>();
    /* *** ChildData ***/
        Map<String, String> curChildMap1 = new HashMap<>();
        children1.add(curChildMap1);
        curChildMap1.put("child", "Bank");

	/* *** ChildData ***/
        Map<String, String> curChildMap2 = new HashMap<>();
        children1.add(curChildMap2);
        curChildMap2.put("child", "Executive");

	/* *** ChildData ***/
        Map<String, String> curChildMap3 = new HashMap<>();
        children1.add(curChildMap3);
        curChildMap3.put("child", "Customer");

	/* ***ChildData ***/
        Map<String, String> curChildMap4 = new HashMap<>();
        children1.add(curChildMap4);
        curChildMap4.put("child", "State");

	/* ***ChildData ***/
        Map<String, String> curChildMap5 = new HashMap<>();
        children1.add(curChildMap5);
        curChildMap5.put("child", "City");

        childData.add(children1);

	/* *************************End Group **************************/

	/* ******************** Start Group  ********************* */
        Map<String, String> curgroupMap2 = new HashMap<>();
        groupData.add(curgroupMap2);
        curgroupMap2.put("parent", "Master 2");
        List<Map<String, String>> children2 = new ArrayList<>();

	/* *** ChildData ***/
        Map<String, String> curChildMap6 = new HashMap<>();
        children2.add(curChildMap6);
        curChildMap6.put("child", "Android");

	/* *** ChildData ***/
        Map<String, String> curChildMap7 = new HashMap<>();
        children2.add(curChildMap7);
        curChildMap7.put("child", "iPhone");

	/* *** ChildData ***/
        Map<String, String> curChildMap8 = new HashMap<>();
        children2.add(curChildMap8);
        curChildMap8.put("child", "Windows");

        childData.add(children2);

	/* *************************End Group **************************/


        mAdapter = new SimpleExpandableListAdapter(
                this,
                groupData,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{"parent"},
                new int[]{android.R.id.text1, android.R.id.text2},
                childData,
                android.R.layout.simple_expandable_list_item_2,
                new String[]{"child"},
                new int[]{android.R.id.text1}
        );
        setListAdapter(mAdapter);

        expand = getExpandableListView();

        expand.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                switch (groupPosition) {
                    case 0:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(getBaseContext(), "Bank",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(getBaseContext(), "Executive",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(getBaseContext(), "Customer",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 3:
                                Toast.makeText(getBaseContext(), "State",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 4:
                                Toast.makeText(getBaseContext(), "City",
                                        Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                    case 1:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(getBaseContext(), "Android",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(getBaseContext(), "iPhone",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(getBaseContext(), "Windows",
                                        Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                }

                return false;
            }
        });
    }
}
