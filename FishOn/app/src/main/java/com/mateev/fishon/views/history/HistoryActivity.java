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
    private Toolbar mDrawerToolbar;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private TabLayout mTabLayout;
    private static HashMap<Integer, IdentifiableFragment> mIdentificationAndFragments;


    static {
        mIdentificationAndFragments = new HashMap<>();
        PreHistoryFragment preHistory = PreHistoryFragment.createNewInstance();
        EarlyHistoryFragment earlyHistory = EarlyHistoryFragment.createNewInstance();
        ModernHistoryFragment modernHistory = ModernHistoryFragment.createNewInstance();

        mIdentificationAndFragments.put(0, preHistory);
        mIdentificationAndFragments.put(1, earlyHistory);
        mIdentificationAndFragments.put(2, modernHistory);
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
    protected long getItemIdentification() {
        return 6;
    }

    private void setupTabLayout() {
        mTabLayout.setSelectedTabIndicatorColor(getColor(R.color.md_white_1000));

        mTabLayout
                .addTab(mTabLayout.newTab()
                        .setText(mIdentificationAndFragments.get(0).getName()));
        mTabLayout
                .addTab(mTabLayout.newTab()
                        .setText(mIdentificationAndFragments.get(1).getName()));
        mTabLayout
                .addTab(mTabLayout.newTab()
                        .setText(mIdentificationAndFragments.get(2).getName()));

    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);

        }


        @Override
        public Fragment getItem(int position) {
            if (position == 0) {

                return (Fragment) mIdentificationAndFragments.get(0);
            } else if (position == 1) {
                return (Fragment) mIdentificationAndFragments.get(1);

            } else {
                return (Fragment) mIdentificationAndFragments.get(2);
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return mIdentificationAndFragments.get(0).getName();
            } else if (position == 1) {
                return mIdentificationAndFragments.get(1).getName();

            } else {
                return mIdentificationAndFragments.get(2).getName();
            }
        }

        @Override
        public int getCount() {
            return mIdentificationAndFragments.size();
        }
    }
}
