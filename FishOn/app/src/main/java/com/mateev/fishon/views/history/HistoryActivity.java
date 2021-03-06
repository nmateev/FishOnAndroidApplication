package com.mateev.fishon.views.history;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.mateev.fishon.R;
import com.mateev.fishon.views.drawerbase.DrawerActivity;

import android.support.v4.app.FragmentManager;

import java.util.HashMap;

public class HistoryActivity extends DrawerActivity {
    public static final int DRAWER_IDENTIFIER = 6;
    public static final int PRE_HISTORY_FRAGMENT_IDENTIFIER = 0;
    public static final int EARLY_HISTORY_FRAGMENT_IDENTIFIER = 1;
    public static final int MODERN_HISTORY_FRAGMENT_IDENTIFIER = 2;

    private static HashMap<Integer, IdentifiableFragment> sIdentificationAndFragments;

    private Toolbar mDrawerToolbar;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private TabLayout mTabLayout;



    static {
        sIdentificationAndFragments = new HashMap<>();
        PreHistoryFragment preHistory = PreHistoryFragment.createNewInstance();
        EarlyHistoryFragment earlyHistory = EarlyHistoryFragment.createNewInstance();
        ModernHistoryFragment modernHistory = ModernHistoryFragment.createNewInstance();

        sIdentificationAndFragments.put(PRE_HISTORY_FRAGMENT_IDENTIFIER, preHistory);
        sIdentificationAndFragments.put(EARLY_HISTORY_FRAGMENT_IDENTIFIER, earlyHistory);
        sIdentificationAndFragments.put(MODERN_HISTORY_FRAGMENT_IDENTIFIER, modernHistory);
    }

    public HistoryActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);

        mViewPager = findViewById(R.id.viewpager);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);

        mTabLayout = findViewById(R.id.sliding_tabs);
        setupTabLayout();

        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mDrawerToolbar;
    }

    @Override
    protected int getDrawerItemIdentification() {
        return DRAWER_IDENTIFIER;
    }

    private void setupTabLayout() {
        mTabLayout.setSelectedTabIndicatorColor(getColor(R.color.md_white_1000));

        mTabLayout
                .addTab(mTabLayout.newTab()
                        .setText(sIdentificationAndFragments.get(PRE_HISTORY_FRAGMENT_IDENTIFIER).getTitleName()));
        mTabLayout
                .addTab(mTabLayout.newTab()
                        .setText(sIdentificationAndFragments.get(EARLY_HISTORY_FRAGMENT_IDENTIFIER).getTitleName()));
        mTabLayout
                .addTab(mTabLayout.newTab()
                        .setText(sIdentificationAndFragments.get(MODERN_HISTORY_FRAGMENT_IDENTIFIER).getTitleName()));

    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);

        }


        @Override
        public Fragment getItem(int position) {
            if (position == PRE_HISTORY_FRAGMENT_IDENTIFIER) {

                return (Fragment) sIdentificationAndFragments.get(PRE_HISTORY_FRAGMENT_IDENTIFIER);
            } else if (position == EARLY_HISTORY_FRAGMENT_IDENTIFIER) {
                return (Fragment) sIdentificationAndFragments.get(EARLY_HISTORY_FRAGMENT_IDENTIFIER);

            } else {
                return (Fragment) sIdentificationAndFragments.get(MODERN_HISTORY_FRAGMENT_IDENTIFIER);
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == PRE_HISTORY_FRAGMENT_IDENTIFIER) {
                return sIdentificationAndFragments.get(PRE_HISTORY_FRAGMENT_IDENTIFIER).getTitleName();
            } else if (position == EARLY_HISTORY_FRAGMENT_IDENTIFIER) {
                return sIdentificationAndFragments.get(EARLY_HISTORY_FRAGMENT_IDENTIFIER).getTitleName();

            } else {
                return sIdentificationAndFragments.get(MODERN_HISTORY_FRAGMENT_IDENTIFIER).getTitleName();
            }
        }

        @Override
        public int getCount() {
            return sIdentificationAndFragments.size();
        }
    }
}
