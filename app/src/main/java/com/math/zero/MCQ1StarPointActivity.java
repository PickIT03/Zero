package com.math.zero;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MCQ1StarPointActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    MaterialRadioButton option1;
    MaterialRadioButton option2;
    MaterialRadioButton option3;
    MaterialRadioButton option4;
    TextView ques;
    Button submit;
    MaterialRadioButton option;
    String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_mcq1_star_point);
        radioGroup = findViewById(R.id.options);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        ques = findViewById(R.id.ques);
        submit = findViewById(R.id.submit);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("mcq1starpoint").child(date);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                MCQModel mcqModel = snapshot.getValue(MCQModel.class);
                ques.setText(mcqModel.getQuestion());
                option1.setText(mcqModel.getOption1());
                option2.setText(mcqModel.getOption2());
                option3.setText(mcqModel.getOption3());
                option4.setText(mcqModel.getOption4());
                answer=mcqModel.getAnswer();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        submit.setOnClickListener(view -> {
            int id = radioGroup.getCheckedRadioButtonId();
            option = findViewById(id);
            String selectedAnswer = option.getText().toString().trim();
            if (selectedAnswer.equals(answer)) {
                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
                RelativeLayout star = findViewById(R.id.star);
                star.setVisibility(View.VISIBLE);
                LottieAnimationView animationView = findViewById(R.id.animation_star);
                animationView.playAnimation();
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    startActivity(new Intent(MCQ1StarPointActivity.this, HomePage.class));
                    finish();
                }, 2500);
            } else {
                Toast.makeText(this, "Please Select Correct Answer", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}