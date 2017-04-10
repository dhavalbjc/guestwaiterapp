package com.example.astics.qrscannetinbuilt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String s = getIntent().getStringExtra("EXTRA_SESSION_ID");
        TextView t=(TextView) findViewById(R.id.textView);
        t.setText(s);
    }
}
