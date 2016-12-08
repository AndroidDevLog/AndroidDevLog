package com.iosdevlog.a239dialogfragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by iosdevlog on 2016/12/8.
 */
public class MyDialogFragment extends DialogFragment {
    int mNum;

    /**
     * Create a new instance of MyDialogFragment, providing "num"
     * as an argument.
     */
    static MyDialogFragment newInstance(int num) {
        MyDialogFragment f = new MyDialogFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("num");

        // Pick a style based on the num.
        int style = DialogFragment.STYLE_NORMAL, theme = 0;
        switch ((mNum-1)%4) {
            case 1: style = DialogFragment.STYLE_NO_TITLE; break;
            case 2: style = DialogFragment.STYLE_NO_FRAME; break;
            case 3: style = DialogFragment.STYLE_NO_INPUT; break;
            case 0: style = DialogFragment.STYLE_NORMAL; break;
        }
        switch ((mNum-1)%5) {
            case 1: theme = android.R.style.Theme_Holo; break;
            case 2: theme = android.R.style.Theme_Holo_Light_Dialog; break;
            case 3: theme = android.R.style.Theme_Holo_Light; break;
            case 4: theme = android.R.style.Theme_Holo_Light_Panel; break;
            case 0: theme = android.R.style.Theme_Holo_Light; break;
        }
        setStyle(style, theme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_dialog, container, false);
        View tv = v.findViewById(R.id.dialgoTextView);
        ((TextView)tv).setText("Dialog #" + mNum + ": using style "
                + getNameForNum(mNum));

        // Watch for button clicks.
        Button button = (Button)v.findViewById(R.id.btnYes);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // When button is clicked, call up to owning activity.
                ((MainActivity)getActivity()).showBasicDialog();
            }
        });

        return v;
    }


    public String getNameForNum(int num) {
        String name = "";
        switch ((num-1)%4) {
            case 1:
                name += "STYLE_NO_TITLE";
                break;
            case 2:
                name += "STYLE_NO_FRAME";
                break;
            case 3:
                name += "STYLE_NO_INPUT";
                break;
            case 0:
                name += "STYLE_NORMAL";
                break;
            default:
                break;
        }

        name += "\t";

        switch ((num-1)%5) {
            case 1:
                name += "Theme_Holo";
                break;
            case 2:
                name += "Theme_Holo_Light_Dialog";
                break;
            case 3:
                name += "Theme_Holo_Light";
                break;
            case 4:
                name += "Theme_Holo_Light_Panel";
                break;
            case 0:
                name += "Theme_Holo_Light";
                break;
            default:
                break;
        }

        return name;
    }
}