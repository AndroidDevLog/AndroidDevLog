package com.iosdevlog.a86staticgallery;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity {

    TextView mySelection;
    Gallery myGallery;
    ImageView img;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] myImageIds = {
                R.drawable.autolayout,
                R.drawable.gameplaykit,
                R.drawable.multitasking,
                R.drawable.protocol,
                R.drawable.valuetypes,
                R.drawable.watchkit,
        };

        mySelection = (TextView) findViewById(R.id.textView2);
        myGallery = (Gallery) findViewById(R.id.myGallery);
        img = (ImageView) findViewById(R.id.imageView1);

        myGallery.setAdapter(new ImageAdapter(this));

        myGallery.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View v,
                                       int position, long id) {
                mySelection.setText(" selected option: " + position);
                img.setImageResource(myImageIds[position]);
            }

            public void onNothingSelected(AdapterView<?> parent) {
                mySelection.setText("Nothing selected");
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {

        private Context myContext;

        private int[] myImageIds = {
                R.drawable.autolayout,
                R.drawable.gameplaykit,
                R.drawable.multitasking,
                R.drawable.protocol,
                R.drawable.valuetypes,
                R.drawable.watchkit,
        };

        public ImageAdapter(Context c) {
            this.myContext = c;
        }

        public int getCount() {
            return this.myImageIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        // Returns a new ImageView to be displayed,
        public View getView(int position, View convertView,
                            ViewGroup parent) {

            ImageView iv = new ImageView(this.myContext);
            iv.setImageResource(this.myImageIds[position]);

            iv.setScaleType(ImageView.ScaleType.FIT_END);

            // Set the Width & Height of the individual images
            iv.setLayoutParams(new Gallery.LayoutParams(300, 200));

            return iv;
        }
    }
}
