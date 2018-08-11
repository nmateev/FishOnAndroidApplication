package com.mateev.fishon.views.personalrecords;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.mateev.fishon.R;
import com.mateev.fishon.views.drawerbase.DrawerActivity;

public class PersonalRecordsActivity extends DrawerActivity {
    private Toolbar mDrawerToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_records);
        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mDrawerToolbar;
    }

    @Override
    protected long getItemIdentification() {
        return 4;
    }
}
