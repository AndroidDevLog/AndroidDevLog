package com.iosdevlog.androidbook;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by iosdevlog on 2016/12/24.
 */

public class MyDialogFragment extends DialogFragment implements View.OnClickListener {
    public interface OnButtonClickListener {
        void onButtonClick(int buttonId);
    }

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View theView = inflater.inflate(R.layout.fragment_my_dialog,
                container, false);

        // Connect the Yes button click event and request focus
        View yesButton = theView.findViewById(R.id.btnYes);
        yesButton.setOnClickListener(this);
        yesButton.requestFocus();
        // Connect the No button click event
        View noButton = theView.findViewById(R.id.btnNo);
        noButton.setOnClickListener(this);
        return theView;
    }

    @Override
    public void onClick(View v) {

        int buttonId = v.getId();
        // Notify the Activity of the button selection
        OnButtonClickListener parentActivity = (OnButtonClickListener)
                getActivity();
        parentActivity.onButtonClick(buttonId);
        // Close the dialog fragment
        dismiss();
    }
}
