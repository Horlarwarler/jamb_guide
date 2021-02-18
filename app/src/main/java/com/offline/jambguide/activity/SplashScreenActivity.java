package com.offline.jambguide.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import com.offline.jambguide.R;

public  class SplashScreenActivity extends Activity{
    Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen_layout);
        handler = new Handler();

        handler.postDelayed(() ->{
                Intent intent = new Intent(SplashScreenActivity.this, PanelActivity.class);
                startActivity(intent);
        },3000
        );
    }
}
