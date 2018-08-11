package com.mateev.fishon.views.fishingtypes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.mateev.fishon.R;
import com.mateev.fishon.views.drawerbase.DrawerActivity;

public class FishingTypeInformationActivity extends DrawerActivity {
    private Toolbar mDrawerToolbar;
    private TextView mFishingInformationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishing_type_information);
        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
        mFishingInformationTextView = findViewById(R.id.tv_fishing_type_information);

        Intent intent = getIntent();
        String informationExtra = intent.getStringExtra("type-information");
        mFishingInformationTextView.setText(informationExtra);

    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mDrawerToolbar;
    }

    @Override
    protected long getItemIdentification() {
        //should not return valid identification
        return -1;

    }
}
