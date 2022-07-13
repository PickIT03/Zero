package com.math.zero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        LinearLayout logout=findViewById(R.id.logout_linear);
        logout.setOnClickListener(view -> {startActivity(new Intent(HomePage.this,LoginActivity.class));finish();});
    }
}