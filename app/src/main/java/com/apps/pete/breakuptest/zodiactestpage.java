package com.apps.pete.breakuptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class zodiactestpage extends AppCompatActivity {

    TextView myzodiac, partnerzodiac, resulttext;
    Button calculatebtn;
    private AdView zodiactestbanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiactestpage);
        myzodiac = (TextView)findViewById(R.id.mybirthday);
        partnerzodiac = (TextView) findViewById(R.id.partnerbirthday);
        resulttext =(TextView)findViewById(R.id.resulttext);
        calculatebtn =(Button) findViewById(R.id.calculatebtn);
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        zodiactestbanner = findViewById(R.id.zodiactestbanner);
        AdRequest adRequest = new AdRequest.Builder().build();
        zodiactestbanner.loadAd(adRequest);
    }
    public void calculatebtnonClick(View view)
    {
       String Myzod = myzodiac.getText().toString();
       String Partzod  = partnerzodiac.getText().toString();


       int num1 = getNumber(Myzod);
       int num2 = getNumber(Partzod);
       int avg = ((num1+num2)/2)%100;

       resulttext.setText(avg + "%");


    }
     private int getNumber(String s)
     {
         int i =0; int sum = 0;
         while (i < s.length())
         {
             char c = s.charAt(i);
             int ASCII = (int) c;
             sum = sum + ASCII;

             i++;
         }
         return sum;
     }
}

