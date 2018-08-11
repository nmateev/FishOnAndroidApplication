package com.mateev.fishon.views.fishingtypes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;

import com.mateev.fishon.R;
import com.mateev.fishon.views.drawerbase.DrawerActivity;

public class FishingTypesActivity extends DrawerActivity {
    private Toolbar mDrawerToolbar;
    private ImageButton mLakeFishingButton;
    private ImageButton mRiverFishingButton;
    private ImageButton mSeaFishingButton;
    private Intent mTypeInformationIntent;
    private AlphaAnimation mButtonClickAnimation;
    private String mFishingInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishing_types);
        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
        mLakeFishingButton = findViewById(R.id.ib_lake_fishing);
        mRiverFishingButton = findViewById(R.id.ib_river_fishing);
        mSeaFishingButton = findViewById(R.id.ib_sea_fishing);
        mButtonClickAnimation = new AlphaAnimation(1F, 0.3F);

        setupImageClickListeners();
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mDrawerToolbar;
    }

    @Override
    protected long getItemIdentification() {
        return 5;
    }

    private void setupImageClickListeners() {
        mLakeFishingButton.setOnClickListener(view -> {
            mFishingInformation = "Information about lake fishing";
            mTypeInformationIntent = new Intent(FishingTypesActivity.this, FishingTypeInformationActivity.class);
            mTypeInformationIntent.putExtra("type-information", mFishingInformation);
            view.startAnimation(mButtonClickAnimation);
            startActivity(mTypeInformationIntent);
        });
        mRiverFishingButton.setOnClickListener(view -> {
            mFishingInformation = "Information about river fishing";
            mTypeInformationIntent = new Intent(FishingTypesActivity.this, FishingTypeInformationActivity.class);
            mTypeInformationIntent.putExtra("type-information", mFishingInformation);
            view.startAnimation(mButtonClickAnimation);
            startActivity(mTypeInformationIntent);
        });
        mSeaFishingButton.setOnClickListener(view -> {
            mFishingInformation = "Information about sea fishing";
            mTypeInformationIntent = new Intent(FishingTypesActivity.this, FishingTypeInformationActivity.class);
            mTypeInformationIntent.putExtra("type-information", mFishingInformation);
            view.startAnimation(mButtonClickAnimation);
            startActivity(mTypeInformationIntent);
        });
    }
}
