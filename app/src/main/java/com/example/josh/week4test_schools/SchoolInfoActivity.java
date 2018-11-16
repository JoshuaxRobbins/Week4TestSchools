package com.example.josh.week4test_schools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SchoolInfoActivity extends AppCompatActivity {

    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_info);
        tvName = findViewById(R.id.tvName);
        tvName.setText(getIntent().getStringExtra("name"));
    }
}
