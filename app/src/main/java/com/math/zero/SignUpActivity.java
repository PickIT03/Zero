package com.math.zero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

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
        TextInputEditText email_et=findViewById(R.id.email);
        TextInputEditText name_et=findViewById(R.id.name);
        TextInputEditText password_et=findViewById(R.id.password);
        RadioGroup radio_grp=findViewById(R.id.radioGroup);
        signup.setOnClickListener(view -> {
            String dept=autoCompleteTextView.getText().toString().trim();
            String email=email_et.getText().toString().trim();
            String name=name_et.getText().toString().trim();
            String password=password_et.getText().toString().trim();
            int id=radio_grp.getCheckedRadioButtonId();
            RadioButton radioButton=findViewById(id);
            String college=radioButton.getText().toString().trim();
            Intent intent=new Intent(SignUpActivity.this,OTPEmailVerification.class);
            intent.putExtra("EMAIL",email);
            intent.putExtra("NAME",name);
            intent.putExtra("PASSWORD",password);
            intent.putExtra("COLLEGE",college);
            intent.putExtra("DEPT",dept);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
        finish();
    }
}