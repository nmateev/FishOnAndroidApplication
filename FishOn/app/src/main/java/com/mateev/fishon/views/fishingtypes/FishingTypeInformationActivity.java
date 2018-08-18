package com.mateev.fishon.views.fishingtypes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.mateev.fishon.R;
import com.mateev.fishon.views.drawerbase.DrawerActivity;

public class FishingTypeInformationActivity extends DrawerActivity {
    private static String INFORMATION_TYPE_KEY = "type-information";
    private static String TOOLBAR_TITLE_KEY = "toolbar-title";
    private static int TOOLBAR_TITLE_MARGIN = 20;
    private Toolbar mDrawerToolbar;
    private TextView mFishingInformationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishing_type_information);
        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
        mFishingInformationTextView = findViewById(R.id.tv_fishing_type_information);

        Intent intent = getIntent();
        String informationExtra = intent.getStringExtra(INFORMATION_TYPE_KEY);
        String toolbarTitle = intent.getStringExtra(TOOLBAR_TITLE_KEY);
        mDrawerToolbar.setTitle(toolbarTitle);
        mDrawerToolbar.setTitleMarginStart(TOOLBAR_TITLE_MARGIN);
        mFishingInformationTextView.setText(informationExtra);


    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mDrawerToolbar;
    }

    @Override
    protected int getDrawerItemIdentification() {
        //should not return valid identification
        return -1;

    }
}
