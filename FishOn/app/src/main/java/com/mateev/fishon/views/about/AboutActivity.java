package com.mateev.fishon.views.about;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Switch;
import android.widget.TextView;

import com.mateev.fishon.R;
import com.mateev.fishon.views.drawerbase.DrawerActivity;


public class AboutActivity extends DrawerActivity {

    public static final int DRAWER_IDENTIFIER = 7;
    public static final int SOUND_VOLUME = 50;
    private TextView mAboutTextView;
    private TextView mRiverHintTextView;
    private Toolbar mDrawerToolbar;
    private MediaPlayer mMediaPlayer;
    private Switch mSwitchRiverSoundMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
        mRiverHintTextView = findViewById(R.id.tv_hint_for_switch_river_sound_mode);
        mSwitchRiverSoundMode = findViewById(R.id.sw_switch_river_sound_on_of);

        mSwitchRiverSoundMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                mMediaPlayer.start();
                mRiverHintTextView.setTextColor(getColor(R.color.colorAccent));
            } else {
                mRiverHintTextView.setTextColor(Color.WHITE);
                mMediaPlayer.pause();
            }
        });

        mAboutTextView = findViewById(R.id.tv_about_text);
        mAboutTextView.setText(R.string.about_activity_information);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer = MediaPlayer.create(this, R.raw.rivercreeksound);
        mMediaPlayer.setVolume(SOUND_VOLUME, SOUND_VOLUME);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMediaPlayer.stop();
        mMediaPlayer.release();
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mDrawerToolbar;
    }

    @Override
    protected int getDrawerItemIdentification() {
        return DRAWER_IDENTIFIER;
    }
}
