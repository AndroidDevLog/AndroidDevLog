package com.iosdevlog.bookdrawerfragment;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BookActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    String[] mTitles;
    String[] mTitlesShort;
    String[] mDescriptions;
    int[] mTopImageResourceIds = {
            R.drawable.db_programming_top_card,
            R.drawable.android_4_top_card,
            R.drawable.sys_dev_top_card,
            R.drawable.and_engine_top_card
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTitles = getResources().getStringArray(R.array.book_titles);
        mTitlesShort = getResources().getStringArray(R.array.book_titles_short);
        mDescriptions = getResources().getStringArray(R.array.book_descriptions);
        mTitle = mTitles[0];

        setContentView(R.layout.activity_book);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);



        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container,
                        PlaceholderFragment.newInstance(
                                mTitles[position],
                                mDescriptions[position],
                                mTopImageResourceIds[position]))
                .commit();
    }

    public void onSectionAttached(int number) {
        mTitle = mTitles[number];
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_TITLE = "title";
        private static final String ARG_DESCRIPTION = "description";
        private static final String ARG_IMAGE_ID = "image id";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(String title, String description, int imageResourceId) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putString(ARG_TITLE, title);
            args.putString(ARG_DESCRIPTION, description);
            args.putInt(ARG_IMAGE_ID, imageResourceId);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_book, container, false);

            TextView bookTitleView = (TextView)rootView.findViewById(R.id.bookTitle);
            TextView bookDescriptionView = (TextView)rootView.findViewById(R.id.bookDescription);
            ImageView topImageView = (ImageView)rootView.findViewById(R.id.topImage);

            Bundle args = getArguments();
            bookTitleView.setText(args.getString(ARG_TITLE));
            bookDescriptionView.setText(args.getString(ARG_DESCRIPTION));
            topImageView.setImageResource(args.getInt(ARG_IMAGE_ID));

            return rootView;
        }
    }

}
