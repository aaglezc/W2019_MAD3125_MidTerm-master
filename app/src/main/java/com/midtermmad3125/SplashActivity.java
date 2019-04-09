package com.midtermmad3125;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.midtermmad3125.ui.MainCityActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        Intent mIntent = new Intent(SplashActivity.this, MainCityActivity.class);
        //Set value to pass on next activity
        SystemClock.sleep(1000);

        startActivity(mIntent);
    }
}
