package com.math.zero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ImageView back=findViewById(R.id.back);
        LinearLayout linearLayout=findViewById(R.id.login);
        back.setOnClickListener(view -> {startActivity(new Intent(SignUpActivity.this,LoginActivity.class));finish();});
        linearLayout.setOnClickListener(view -> {startActivity(new Intent(SignUpActivity.this,LoginActivity.class));finish();});
        String[] department=getResources().getStringArray(R.array.department);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,R.layout.dropdown_list,department);
        AutoCompleteTextView autoCompleteTextView=findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.setAdapter(arrayAdapter);
        Button signup=findViewById(R.id.signup);
        signup.setOnClickListener(view -> {
            String dept=autoCompleteTextView.getText().toString().trim();
            System.out.println(dept);
            Toast.makeText(this, dept, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
        finish();
    }
}