package com.example.lorentzfactor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LorentzActivity extends AppCompatActivity {
    private EditText editText,Guess;
    private Button Calculate;
    private TextView textView;
    public Vibrator v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_lorentz);
        Calculate = findViewById(R.id.calc_btn);
        editText = findViewById(R.id.question);
        textView = findViewById(R.id.solution);
        Guess = findViewById(R.id.guess);
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().trim().length()<=0||Guess.getText().toString().trim().length()<=0){
                    Toast.makeText(LorentzActivity.this,"Please fill all fields!",Toast.LENGTH_SHORT).show();
                }
                else{
                    calc();
                }
            }
        });
    }
    public void calc()
    {
        String s = editText.getText().toString();
        long vel = Long.parseLong(s);
        if(vel<300000000){
            double lorentz = 1 / Math.sqrt(1-((vel*vel)/(300000000*300000000)));
            check(lorentz);
        }
        else{
            Toast.makeText(LorentzActivity.this,"Invalid Input",Toast.LENGTH_SHORT).show();
        }
    }
    public void check(double l)
    {
        String g = Guess.getText().toString();
        double gue = Double.parseDouble(g);
        if(gue==l){
            correctprint(l);
        }
        else{
            v.vibrate(1000);
            wrongprint(l);
        }
    }
    public void correctprint(double c){
        View view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.correctColor);
        textView.setText("Correct Answer! The lorentz factor is " + c);
    }
    public void wrongprint(double w){
        View view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.wrongColor);
        textView.setText("Wrong Answer! The lorentz factor is " + w);
    }
}