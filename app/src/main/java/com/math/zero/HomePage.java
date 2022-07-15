package com.math.zero;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        LinearLayout logout=findViewById(R.id.logout_linear);
        logout.setOnClickListener(view -> {
            new MaterialAlertDialogBuilder(this,R.style.AlertDialogTheme)
                    .setTitle("Logout")
                    .setMessage("Are you sure want to logout !")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            startActivity(new Intent(HomePage.this,LoginActivity.class));
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .show();
        });
        RelativeLayout mcqOpen=findViewById(R.id.mcq_open);
        RelativeLayout mcqClose=findViewById(R.id.mcq_close);
        RelativeLayout solveOpen=findViewById(R.id.solve_open);
        RelativeLayout solveClose=findViewById(R.id.solve_close);
        LinearLayout mcq=findViewById(R.id.mcq);
        LinearLayout solve=findViewById(R.id.solve);
        mcqClose.setOnClickListener(view -> {
            mcq.setVisibility(View.GONE);
            mcqOpen.setVisibility(View.VISIBLE);
            mcqClose.setVisibility(View.GONE);
        });
        mcqOpen.setOnClickListener(view -> {
            mcq.setVisibility(View.VISIBLE);
            mcqClose.setVisibility(View.VISIBLE);
            mcqOpen.setVisibility(View.GONE);
        });
        solveClose.setOnClickListener(view -> {
            solve.setVisibility(View.GONE);
            solveOpen.setVisibility(View.VISIBLE);
            solveClose.setVisibility(View.GONE);
        });
        solveOpen.setOnClickListener(view -> {
            solve.setVisibility(View.VISIBLE);
            solveClose.setVisibility(View.VISIBLE);
            solveOpen.setVisibility(View.GONE);
        });
    }
}