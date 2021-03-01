package com.offline.jambguide.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.offline.jambguide.R;

public class PanelActivity extends AppCompatActivity {

    private InterstitialAd myInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);
        myInterstitialAd = new InterstitialAd(this);
        myInterstitialAd.setAdUnitId(getString(R.string.admob_interstitial_id));
        myInterstitialAd.loadAd(new AdRequest.Builder().build());
    }
}

