package com.math.zero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_login);
        Button button=findViewById(R.id.login);
        button.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this,HomePage.class));
            finish();
        });
        LinearLayout layout=findViewById(R.id.signup);
        layout.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}