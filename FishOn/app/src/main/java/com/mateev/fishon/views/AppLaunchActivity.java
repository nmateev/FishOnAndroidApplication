package com.mateev.fishon.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.mateev.fishon.R;
import com.mateev.fishon.views.home.HomeActivity;

public class AppLaunchActivity extends AppCompatActivity {
    private static final float FROM_ALPHA_ANIMATION = 1F;
    private static final float TO_ALPHA_ANIMATION = 0.3F;
    private static final int ALPHA_ANIMATION_DURATION = 1000;

    private ImageView mAppLaunchImage;
    private TextView mClickAnywhereMessage;
    private AlphaAnimation mAnimatedText;

    public AppLaunchActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_launch);
        mAppLaunchImage = findViewById(R.id.iv_app_launch_image);
        mClickAnywhereMessage = findViewById(R.id.tv_click_anywhere_message);
        mAnimatedText = new AlphaAnimation(FROM_ALPHA_ANIMATION, TO_ALPHA_ANIMATION);
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

    private void animateText(TextView textView) {

        mAnimatedText.setDuration(ALPHA_ANIMATION_DURATION);
        mAnimatedText.setRepeatMode(Animation.REVERSE);
        mAnimatedText.setRepeatCount(Animation.INFINITE);
        textView.startAnimation(mAnimatedText);
    }
}
