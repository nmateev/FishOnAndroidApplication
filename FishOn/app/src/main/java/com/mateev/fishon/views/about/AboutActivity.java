package com.mateev.fishon.views.about;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.mateev.fishon.R;
import com.mateev.fishon.views.drawerbase.DrawerActivity;

public class AboutActivity extends DrawerActivity {
    private TextView mAboutTextView;
    private Toolbar mDrawerToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);

        mAboutTextView = findViewById(R.id.tv_about_text);
        mAboutTextView.setText("About information");
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mDrawerToolbar;
    }

    @Override
    protected long getItemIdentification() {
        return 7;
    }
}
