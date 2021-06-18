package com.example.lorentzfactor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NormalActivity extends AppCompatActivity {
    private EditText Ques;
    private Button Calc, Prac;
    private TextView Soln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_normal);
        Calc = findViewById(R.id.calc_btn);
        Ques = findViewById(R.id.question);
        Soln = findViewById(R.id.solution);
        Prac = findViewById(R.id.practice_btn);

        Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Ques.getText().toString().trim().length() <= 0) {
                    Toast.makeText(NormalActivity.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                } else {
                    String s = Ques.getText().toString();
                    long ve = Long.parseLong(s);
                    if (ve < 300000000) {
                        double lorentz = 1 / Math.sqrt(1 - ((ve * ve) / (300000000 * 300000000)));
                        Soln.setText("The lorentz factor is " + lorentz);
                    } else {
                        Toast.makeText(NormalActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        Prac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this,LorentzActivity.class);
                startActivity(intent);
            }
        });
    }
}