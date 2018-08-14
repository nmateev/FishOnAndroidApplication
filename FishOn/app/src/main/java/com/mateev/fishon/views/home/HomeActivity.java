package com.mateev.fishon.views.home;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mateev.fishon.R;
import com.mateev.fishon.views.drawerbase.DrawerActivity;

import java.util.Objects;

public class HomeActivity extends DrawerActivity {
    public static final int DRAWER_IDENTIFIER = 1;
    private Toolbar mDrawerToolbar;
    private HomeActivityFragment mHomeActivityFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
        mHomeActivityFragment = HomeActivityFragment.createNewInstance();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fr_home_content, mHomeActivityFragment)
                .commit();


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
