package com.mateev.fishon.views;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.mateev.fishon.R;

import java.util.Objects;

public class HomeActivity extends DrawerActivity {
    private Toolbar mDrawerToolbar;
    private HomeActivityFragment mHomeActivityFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
        setSupportActionBar(mDrawerToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        //   getSupportActionBar().setIcon(R.drawable.search);
        mHomeActivityFragment = HomeActivityFragment.createNewInstance();

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.quote_content, mHomeActivityFragment)
                .commit();


    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mDrawerToolbar;
    }

    @Override
    protected long getItemIdentification() {
        return 0;
    }
}
