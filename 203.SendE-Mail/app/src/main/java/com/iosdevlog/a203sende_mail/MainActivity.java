package com.iosdevlog.a203sende_mail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button Send;
    EditText TO, CC, SUBJECT, MSG;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Send = (Button) findViewById(R.id.button1);
        TO = (EditText) findViewById(R.id.editText1);
        CC = (EditText) findViewById(R.id.editText2);
        SUBJECT = (EditText) findViewById(R.id.editText3);
        MSG = (EditText) findViewById(R.id.editText4);

        Send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String to = TO.getText().toString();
                String cc = CC.getText().toString();
                String subject = SUBJECT.getText().toString();
                String msg = MSG.getText().toString();

                sendEmail(to, cc, subject, msg);

                TO.setText(null);
                CC.setText(null);
                SUBJECT.setText(null);
                MSG.setText(null);
            }
        });
    }

    private void sendEmail(String emailAddresses, String carbonCopies,
                           String subject, String message) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        String to = emailAddresses;
        String cc = carbonCopies;

        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.setType("message/rfc822");

        startActivity(Intent.createChooser(emailIntent, "Email"));
    }
}
