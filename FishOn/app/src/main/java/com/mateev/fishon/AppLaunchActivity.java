package com.mateev.fishon;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AppLaunchActivity extends AppCompatActivity {
    private ImageView mAppLaunchImage;
    private TextView mClickAnywhereMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_launch);
        mAppLaunchImage = findViewById(R.id.iv_app_launch_image);
        mClickAnywhereMessage = findViewById(R.id.tv_click_anywhere_message);
        animateText(mClickAnywhereMessage);
        Context mLaunchActivityContext = this;

        mAppLaunchImage.setClickable(true);
        mAppLaunchImage.setOnClickListener(view -> {
            Intent intent = new Intent(mLaunchActivityContext, HomeActivity.class);
            startActivity(intent);
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    private static void animateText(TextView textView) {
        Animation animatedText = new AlphaAnimation(0.0f, 3.0f);
        animatedText.setDuration(1000);
        animatedText.setStartOffset(10);
        animatedText.setRepeatMode(Animation.REVERSE);
        animatedText.setRepeatCount(Animation.INFINITE);
        textView.startAnimation(animatedText);
    }
}