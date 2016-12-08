package com.iosdevlog.a237layoutaliasing;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookDescFragment extends Fragment {

    String[] mBookDescriptions;
    TextView mBookDescriptionTextView;

    public BookDescFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewHierarchy =
                inflater.inflate(R.layout.fragment_book_desc, container,
                        false);
        // Load array of book descriptions
        mBookDescriptions = getResources().
                getStringArray(R.array.book_descriptions);
        // Get reference to book description text view
        mBookDescriptionTextView = (TextView)
                viewHierarchy.findViewById(R.id.bookDescription);

        return viewHierarchy;
    }

    public void setBook(int bookIndex) {
        // Lookup the book description
        String bookDescription = mBookDescriptions[bookIndex];

        // Display it
        mBookDescriptionTextView.setText(bookDescription);
    }
}
