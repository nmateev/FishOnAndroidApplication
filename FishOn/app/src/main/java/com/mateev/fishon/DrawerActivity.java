package com.mateev.fishon;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public abstract class DrawerActivity extends AppCompatActivity {
    private Drawer mDrawer;

    private void setupDrawer(Drawer mDrawer) {
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("Android");

//create the drawer and remember the `Drawer` result object
        mDrawer = new DrawerBuilder()
                .withActivity(DrawerActivity.this)
                .withToolbar(getDrawerToolbar())
                .withTranslucentStatusBar(false)
                .addDrawerItems(
                        item1.withIcon(GoogleMaterial.Icon.gmd_home),
                        new DividerDrawerItem(),
                        item2.withIcon(GoogleMaterial.Icon.gmd_android),
                        new SecondaryDrawerItem().withName("Settings"),
                        new DividerDrawerItem()
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {


                        return true;
                    }
                })
                .build();
    }

    protected abstract Toolbar getDrawerToolbar();

    protected abstract long getItemIdentification();

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer(mDrawer);
    }
}
