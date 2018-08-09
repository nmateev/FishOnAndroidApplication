package com.mateev.fishon;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import java.util.Objects;

public class HomeActivity extends DrawerActivity {
    private Toolbar mDrawerToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
        setSupportActionBar(mDrawerToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
     //   getSupportActionBar().setIcon(R.drawable.search);

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
