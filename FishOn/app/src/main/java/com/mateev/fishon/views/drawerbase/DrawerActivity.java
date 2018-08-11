package com.mateev.fishon.views.drawerbase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mateev.fishon.R;
import com.mateev.fishon.views.about.AboutActivity;
import com.mateev.fishon.views.fishingtypes.FishingTypesActivity;
import com.mateev.fishon.views.history.HistoryActivity;
import com.mateev.fishon.views.home.HomeActivity;
import com.mateev.fishon.views.personalrecords.PersonalRecordsActivity;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public abstract class DrawerActivity extends AppCompatActivity {
    private Drawer mDrawer;

    private void setupDrawer() {

        AccountHeader header = new AccountHeaderBuilder()
                .withActivity(DrawerActivity.this)
                .withHeaderBackground(R.drawable.drawerheader)
                .withTranslucentStatusBar(true)
                .withCompactStyle(true)
                .build();

        PrimaryDrawerItem item1 = new PrimaryDrawerItem()
                .withIdentifier(1)
                .withName("Home");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem()
                .withIdentifier(2)
                .withName("Wish list");
        SecondaryDrawerItem item3 = new SecondaryDrawerItem()
                .withIdentifier(3)
                .withName("Visited places");
        SecondaryDrawerItem item4 = new SecondaryDrawerItem()
                .withIdentifier(4)
                .withName("Personal records");
        SecondaryDrawerItem item5 = new SecondaryDrawerItem()
                .withIdentifier(5)
                .withName("Fishing types");
        SecondaryDrawerItem item6 = new SecondaryDrawerItem()
                .withIdentifier(6)
                .withName("History");
        SecondaryDrawerItem item7 = new SecondaryDrawerItem()
                .withIdentifier(7)
                .withName("About");


        mDrawer = new DrawerBuilder().
                withCloseOnClick(true)
                .withActivity(DrawerActivity.this)
                .withToolbar(getDrawerToolbar())
                .withTranslucentStatusBar(false)
                .withAccountHeader(header)
                .addDrawerItems(
                        item1.withIcon(GoogleMaterial.Icon.gmd_home),
                        new DividerDrawerItem(),
                        item2.withIcon(GoogleMaterial.Icon.gmd_android),
                        new DividerDrawerItem(),
                        item3.withIcon(GoogleMaterial.Icon.gmd_android),
                        new DividerDrawerItem(),
                        item4.withIcon(R.drawable.drawerpersonalrecordsicon),
                        new DividerDrawerItem(),
                        item5.withIcon(R.drawable.fishingtypesicon),
                        new DividerDrawerItem(),
                        item6.withIcon(R.drawable.drawerhistoryicon),
                        new DividerDrawerItem(),
                        item7.withIcon(GoogleMaterial.Icon.gmd_info)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        long mDrawerPosition = drawerItem.getIdentifier();
                        if (mDrawerPosition == 6) {
                            Intent intent = new Intent(DrawerActivity.this, HistoryActivity.class);
                            startActivity(intent);
                        } else if (mDrawerPosition == 7) {
                            Intent intent = new Intent(DrawerActivity.this, AboutActivity.class);
                            startActivity(intent);
                        }else if(mDrawerPosition ==1){
                            Intent intent = new Intent(DrawerActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }else if(mDrawerPosition ==5){
                            Intent intent = new Intent(DrawerActivity.this, FishingTypesActivity.class);
                            startActivity(intent);
                        }else if(mDrawerPosition ==4){
                            Intent intent = new Intent(DrawerActivity.this, PersonalRecordsActivity.class);
                            startActivity(intent);
                        }
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
        setupDrawer();
    }
}
