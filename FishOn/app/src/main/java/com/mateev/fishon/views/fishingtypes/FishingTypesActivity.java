package com.mateev.fishon.views.fishingtypes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;

import com.mateev.fishon.R;
import com.mateev.fishon.views.drawerbase.DrawerActivity;

public class FishingTypesActivity extends DrawerActivity implements View.OnClickListener {
    public static final int DRAWER_IDENTIFIER = 5;
    private static final float FROM_ALPHA_ANIMATION = 1F;
    private static final float TO_ALPHA_ANIMATION = 0.3F;
    private static String INFORMATION_TYPE_KEY = "type-information";
    private static String TOOLBAR_TITLE_KEY = "toolbar-title";
    private static String LAKE_FISHING_TITLE = "Lake Fishing";
    private static String RIVER_FISHING_TITLE = "River Fishing";
    private static String SEA_FISHING_TITLE = "Sea Fishing";
    private Toolbar mDrawerToolbar;
    private ImageButton mLakeFishingButton;
    private ImageButton mRiverFishingButton;
    private ImageButton mSeaFishingButton;
    private Intent mTypeInformationIntent;
    private AlphaAnimation mButtonClickAnimation;
    private String mFishingInformation;
    private String mToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishing_types);
        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
        mLakeFishingButton = findViewById(R.id.ib_lake_fishing);
        mRiverFishingButton = findViewById(R.id.ib_river_fishing);
        mSeaFishingButton = findViewById(R.id.ib_sea_fishing);
        mLakeFishingButton.setOnClickListener(this);
        mRiverFishingButton.setOnClickListener(this);
        mSeaFishingButton.setOnClickListener(this);
        mButtonClickAnimation = new AlphaAnimation(FROM_ALPHA_ANIMATION, TO_ALPHA_ANIMATION);

    }

    @Override
    public void onClick(View view) {
        mTypeInformationIntent = new Intent(FishingTypesActivity.this, FishingTypeInformationActivity.class);
        switch (view.getId()) {
            case R.id.ib_lake_fishing:
                mFishingInformation = "Information about lake fishing";
                mToolbarTitle = LAKE_FISHING_TITLE;
                break;
            case R.id.ib_river_fishing:
                mFishingInformation = "Information about river fishing";
                mToolbarTitle = RIVER_FISHING_TITLE;
                break;
            case R.id.ib_sea_fishing:
                mFishingInformation = "Information about sea fishing";
                mToolbarTitle = SEA_FISHING_TITLE;
                break;
        }
        mTypeInformationIntent.putExtra(INFORMATION_TYPE_KEY, mFishingInformation);
        mTypeInformationIntent.putExtra(TOOLBAR_TITLE_KEY, mToolbarTitle);
        view.startAnimation(mButtonClickAnimation);
        startActivity(mTypeInformationIntent);
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
