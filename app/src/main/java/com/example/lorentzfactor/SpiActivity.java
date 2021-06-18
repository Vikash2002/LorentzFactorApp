package com.example.lorentzfactor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Calendar;

public class SpiActivity extends AppCompatActivity {
    public TextView Value;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_spi);

        Value = findViewById(R.id.textView6);
        timer();
    }
    public void timer()
    {
        Thread t=new Thread(){
           @Override
           public void run(){
               while(!isInterrupted()){
                   try {
                       Thread.sleep(1000);
                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               count++;
                               print();
                           }
                       });
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
        };
        t.start();
    }
    public void print()
    {
        int h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int m = Calendar.getInstance().get(Calendar.MINUTE);
        int s = Calendar.getInstance().get(Calendar.SECOND);
        int hour = conv(h);
        int num = fact(hour);
        int den = ((m*m*m)+s);
        double spi = ((double)num / (double)den);
        Value.setText("The spi factor is " + spi);
    }
    public int fact(int n)
    {
        int prod=1;
        for(int i=1;i<=n;i++){
            prod*=i;
        }
        return prod;
    }
    public int conv(int v)
    {
        int format;
        if(v>12){
            format = v - 12;
            return format;
        }
        else{
            return v;
        }
    }
}