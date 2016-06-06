package com.akaimma.listviewfirstwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LastActivity extends AppCompatActivity {

    TextView name,phone, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        name = (TextView) findViewById(R.id.opName);
        phone = (TextView) findViewById(R.id.opPhone);
        email = (TextView) findViewById(R.id.opEmail);

        Intent i = getIntent();
        name.setText(i.getStringExtra("name"));
        phone.setText(i.getStringExtra("phone"));
        email.setText(i.getStringExtra("email"));
    }
}
