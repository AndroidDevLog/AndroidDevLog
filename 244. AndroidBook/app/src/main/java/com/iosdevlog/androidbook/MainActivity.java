package com.iosdevlog.androidbook;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements OnSelectedBookChangeListener, MyDialogFragment.OnButtonClickListener {

    boolean mCreating = true;
    private boolean mIsDynamic;
    BookListFragment listFragment;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();


        // Get the book description fragment
        FragmentManager fm = getFragmentManager();
        Fragment bookDescFragment =
                fm.findFragmentById(R.id.fragmentDescription);

        // If not found than we're doing dynamic mgmt
        mIsDynamic = bookDescFragment == null ||
                !bookDescFragment.isInLayout();


        // Load the list fragment if necessary
        if (mIsDynamic) {
            // Begin transaction
            FragmentTransaction ft = fm.beginTransaction();

            // Create the Fragment and add
            listFragment = new BookListFragment();
            ft.add(R.id.layoutRoot, listFragment);

            // Commit the changes
            ft.commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCreating = false;
    }

    @Override
    public void onButtonClick(int buttonId) {
        Toast.makeText(this, "" + buttonId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSelectedBookChanged(int bookIndex) {

        BookDescFragment bookDescFragment;
        FragmentManager fm = getFragmentManager();

        // Check validity of fragment reference
        if(mIsDynamic){
            // Handle dynamic switch to description fragment
            FragmentTransaction ft = fm.beginTransaction();

            // Create the fragment and pass the book index
            bookDescFragment = BookDescFragment.newInstance(bookIndex);

            // Replace the book list with the description
//            ft.replace(R.id.layoutRoot,
//                    bookDescFragment);
            ft.remove(listFragment);
//            ft.hide(listFragment);
            ft.add(R.id.layoutRoot, bookDescFragment, "bookDescFragment");
            ft.addToBackStack(null);
            ft.setCustomAnimations(
                    android.R.animator.fade_in, android.R.animator.fade_out);
            ft.commit();
        }
        else {
            // Use the already visible description fragment
            bookDescFragment = (BookDescFragment)
                    fm.findFragmentById(R.id.fragmentDescription);
            bookDescFragment.setBook(bookIndex);
        }
    }

}
