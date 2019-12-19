package com.apps.pete.breakuptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class testspage extends AppCompatActivity {
    private AdView testspagebanner;
    private InterstitialAd theInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testspage);
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        testspagebanner = findViewById(R.id.testspagebanner);
        AdRequest adRequest = new AdRequest.Builder().build();
        testspagebanner.loadAd(adRequest);
        theInterstitialAd = new InterstitialAd(this);
        theInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        theInterstitialAd.loadAd(new AdRequest.Builder().build());
        theInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                theInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });
    }
    public void nametestbtnonClick(View view)
    {
        Intent myintent;
        myintent = new Intent(testspage.this, nametestpage.class);
        startActivity(myintent);
        theInterstitialAd.show();
    }
    public void zodiactestbtnonClick(View view)
    {
        Intent myintent;
        myintent = new Intent(testspage.this, zodiactestpage.class);
        startActivity(myintent);

    }
    public void birthdaytestbtnonClick(View view)
    {
        Intent myintent;
        myintent = new Intent(testspage.this, birthdaytestpage.class);
        startActivity(myintent);
        theInterstitialAd.show();
    }
}
