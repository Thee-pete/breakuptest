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

import hotchemi.android.rate.AppRate;

public class firstpage extends AppCompatActivity {
    private AdView firstpagebanner;
    private InterstitialAd theInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        firstpagebanner = findViewById(R.id.firstpagebanner);
        AdRequest adRequest = new AdRequest.Builder().build();
        firstpagebanner.loadAd(adRequest);
        theInterstitialAd = new InterstitialAd(this);
        theInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        theInterstitialAd.loadAd(new AdRequest.Builder().build());
        theInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                theInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

        AppRate.with(this)
                .setInstallDays(0)
                .setLaunchTimes(2)
                .setRemindInterval(2)
                .monitor();

        AppRate.showRateDialogIfMeetsConditions(this);
    }
    public void choosebtnonClick(View view)
    {
        Intent myintent;
        myintent = new Intent(firstpage.this, testspage.class);
        startActivity(myintent);
        theInterstitialAd.show();

    }
}
