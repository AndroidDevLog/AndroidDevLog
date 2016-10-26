package com.iosdevlog.a226generateqrcode;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.DialogInterface.OnClickListener;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    private static final int ACTIVITY_RESULT_QR_DRDROID = 0;

    Button generate;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generate = (Button) findViewById(R.id.button1);
        edit = (EditText) findViewById(R.id.editText1);

        generate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                String code = edit.getText().toString();

                if (code.trim().length() == 0) {

                    Toast.makeText(getBaseContext(),
                            "Enter Text", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent encode = new Intent("la.droid.qr.encode");
                encode.putExtra("la.droid.qr.code", code);
                encode.putExtra("la.droid.qr.image", true);
                encode.putExtra("la.droid.qr.size", 0);

                try {

                    startActivityForResult(encode, ACTIVITY_RESULT_QR_DRDROID);
                } catch (ActivityNotFoundException activity) {

                    qrDroidRequired(MainActivity.this);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (ACTIVITY_RESULT_QR_DRDROID == requestCode
                && data != null && data.getExtras() != null) {

            ImageView imgResult = (ImageView) findViewById(R.id.img_result);

            String qrCode = data.getExtras().getString("la.droid.qr.result");

            if (qrCode == null || qrCode.trim().length() == 0) {

                Toast.makeText(getBaseContext(), "QR Code Image " +
                        "is not Saved", Toast.LENGTH_LONG).show();
                return;
            }

            Toast.makeText(getBaseContext(), "QR Code Image is Saved"
                    + " " + qrCode, Toast.LENGTH_LONG).show();

            imgResult.setImageURI(Uri.parse(qrCode));

            imgResult.setVisibility(View.VISIBLE);
        }
    }

	/*
     *
	 * If we don't have QRDroid Application in our Device,
	 * It will call below method (qrDroidRequired)
	 *
	 */

    protected static void qrDroidRequired(final MainActivity activity) {
        AlertDialog.Builder AlertBox = new AlertDialog.Builder(activity);

        AlertBox.setMessage("QRDroid Missing");

        AlertBox.setPositiveButton("Direct Download", new OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                activity.startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://droid.la/apk/qr/")));
            }
        });

        AlertBox.setNeutralButton("From Market", new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://market.android.com/details?id=la.droid.qr")));
            }
        });

        AlertBox.setNegativeButton("Cancel", new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertBox.create().show();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //Nothing
    }
}
