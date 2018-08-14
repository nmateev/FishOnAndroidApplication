package com.mateev.fishon.views.personalrecords;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.Toast;

import com.mateev.fishon.R;
import com.mateev.fishon.views.drawerbase.DrawerActivity;

public class PersonalRecordsActivity extends DrawerActivity implements View.OnClickListener {
    private static final float FROM_ALPHA_ANIMATION = 1F;
    private static final float TO_ALPHA_ANIMATION = 0.3F;
    public static final int DRAWER_IDENTIFIER = 4;
    private Toolbar mDrawerToolbar;
    private ImageButton mAddNewRecordImageButton;
    private AlphaAnimation mImageButtonClickAnimation;
    private RecordsListFragment mRecordsListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_records);
        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
        mAddNewRecordImageButton = findViewById(R.id.ib_add_new_record);
        mAddNewRecordImageButton.setOnClickListener(this);
        mImageButtonClickAnimation = new AlphaAnimation(FROM_ALPHA_ANIMATION, TO_ALPHA_ANIMATION);
        mRecordsListFragment = RecordsListFragment.createNewInstance();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fr_personal_records_list, mRecordsListFragment)
                .commit();

        Toast.makeText(this, R.string.add_new_record_tip_message, Toast.LENGTH_LONG)
                .show();
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mDrawerToolbar;
    }

    @Override
    protected int getDrawerItemIdentification() {
        return DRAWER_IDENTIFIER;
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, AddNewFishRecordActivity.class);
        view.startAnimation(mImageButtonClickAnimation);
        startActivity(intent);
    }
}
