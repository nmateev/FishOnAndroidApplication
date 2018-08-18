package com.mateev.fishon.views.home;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.widget.Toolbar;

import com.mateev.fishon.R;
import com.mateev.fishon.views.drawerbase.DrawerActivity;

import java.util.Objects;

public class HomeActivity extends DrawerActivity {
    public static final int DRAWER_IDENTIFIER = 1;
    private static final String SAVED_FRAGMENT_STATE_KEY = "home_activity_fragment";
    private Toolbar mDrawerToolbar;
    private HomeActivityFragment mHomeActivityFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
        if (Objects.equals(savedInstanceState, null)) {
            mHomeActivityFragment = HomeActivityFragment.createNewInstance();
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fr_home_content, mHomeActivityFragment)
                    .commit();
        } else {
            mHomeActivityFragment =
                    (HomeActivityFragment) getFragmentManager()
                            .getFragment(savedInstanceState, SAVED_FRAGMENT_STATE_KEY);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        getFragmentManager()
                .putFragment(outState, SAVED_FRAGMENT_STATE_KEY,
                        mHomeActivityFragment);
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
