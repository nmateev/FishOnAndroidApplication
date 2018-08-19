package com.mateev.fishon.views.drawerbase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mateev.fishon.R;
import com.mateev.fishon.views.about.AboutActivity;
import com.mateev.fishon.views.fishingtypes.FishingTypesActivity;
import com.mateev.fishon.views.history.HistoryActivity;
import com.mateev.fishon.views.home.HomeActivity;
import com.mateev.fishon.views.locatons.visitedplaces.VisitedPlacesActivity;
import com.mateev.fishon.views.locatons.wishlist.WishListActivity;
import com.mateev.fishon.views.personalrecords.PersonalRecordsActivity;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;

import java.util.Objects;

public abstract class DrawerActivity extends AppCompatActivity {
    private static final String HOME_DRAWER_ITEM_NAME = "Home";
    private static final String WISH_LIST_DRAWER_ITEM_NAME = "Wish List";
    private static final String VISITED_PLACES_DRAWER_ITEM_NAME = "Visited Places";
    private static final String PERSONAL_RECORDS_DRAWER_ITEM_NAME = "Personal Records";
    private static final String FISHING_TYPES_DRAWER_ITEM_NAME = "Fishing Types";
    private static final String HISTORY_DRAWER_ITEM_NAME = "History";
    private static final String ABOUT_DRAWER_ITEM_NAME = "About";
    private Drawer mDrawer;

    private void setupDrawer() {

        AccountHeader header = new AccountHeaderBuilder()
                .withActivity(DrawerActivity.this)
                .withHeaderBackground(R.drawable.drawerheader)
                .withTranslucentStatusBar(true)
                .withCompactStyle(true)
                .build();

        PrimaryDrawerItem homeDrawerItem = new PrimaryDrawerItem()
                .withIdentifier(HomeActivity.DRAWER_IDENTIFIER)
                .withName(HOME_DRAWER_ITEM_NAME);
        SecondaryDrawerItem wishListDrawerItem = new SecondaryDrawerItem()
                .withIdentifier(WishListActivity.DRAWER_IDENTIFIER)
                .withName(WISH_LIST_DRAWER_ITEM_NAME);
        SecondaryDrawerItem visitedPlacesDrawerItem = new SecondaryDrawerItem()
                .withIdentifier(VisitedPlacesActivity.DRAWER_IDENTIFIER)
                .withName(VISITED_PLACES_DRAWER_ITEM_NAME);
        SecondaryDrawerItem personalRecordsDrawerItem = new SecondaryDrawerItem()
                .withIdentifier(PersonalRecordsActivity.DRAWER_IDENTIFIER)
                .withName(PERSONAL_RECORDS_DRAWER_ITEM_NAME);
        SecondaryDrawerItem fishingTypesDrawerItem = new SecondaryDrawerItem()
                .withIdentifier(FishingTypesActivity.DRAWER_IDENTIFIER)
                .withName(FISHING_TYPES_DRAWER_ITEM_NAME);
        SecondaryDrawerItem historyDrawerItem = new SecondaryDrawerItem()
                .withIdentifier(HistoryActivity.DRAWER_IDENTIFIER)
                .withName(HISTORY_DRAWER_ITEM_NAME);
        SecondaryDrawerItem aboutDrawerItem = new SecondaryDrawerItem()
                .withIdentifier(AboutActivity.DRAWER_IDENTIFIER)
                .withName(ABOUT_DRAWER_ITEM_NAME);


        mDrawer = new DrawerBuilder()
                .withCloseOnClick(true)
                .withActivity(DrawerActivity.this)
                .withToolbar(getDrawerToolbar())
                .withTranslucentStatusBar(false)
                .withAccountHeader(header)
                .addDrawerItems(
                        homeDrawerItem
                                .withIcon(GoogleMaterial.Icon.gmd_home),
                        new DividerDrawerItem(),
                        wishListDrawerItem
                                .withIcon(R.drawable.drawerwishlisticon),
                        new DividerDrawerItem(),
                        visitedPlacesDrawerItem
                                .withIcon(R.drawable.drawervisitedplaces),
                        new DividerDrawerItem(),
                        personalRecordsDrawerItem
                                .withIcon(R.drawable.drawerpersonalrecordsicon),
                        new DividerDrawerItem(),
                        fishingTypesDrawerItem
                                .withIcon(R.drawable.drawerfishingtypesicon),
                        new DividerDrawerItem(),
                        historyDrawerItem
                                .withIcon(R.drawable.drawerhistoryicon),
                        new DividerDrawerItem(),
                        aboutDrawerItem
                                .withIcon(GoogleMaterial.Icon.gmd_info)
                )
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {

                    int clickedDrawerItemPosition = (int) drawerItem.getIdentifier();

                    if (clickedDrawerItemPosition == getDrawerItemIdentification()) {
                        mDrawer.closeDrawer();
                        return false;
                    }
                    Intent intent = null;
                    switch (clickedDrawerItemPosition) {
                        case HomeActivity.DRAWER_IDENTIFIER:
                            intent = new Intent(DrawerActivity.this, HomeActivity.class);
                            break;
                        case WishListActivity.DRAWER_IDENTIFIER:
                            intent = new Intent(DrawerActivity.this, WishListActivity.class);
                            break;
                        case VisitedPlacesActivity.DRAWER_IDENTIFIER:
                            intent = new Intent(DrawerActivity.this, VisitedPlacesActivity.class);
                            break;
                        case PersonalRecordsActivity.DRAWER_IDENTIFIER:
                            intent = new Intent(DrawerActivity.this, PersonalRecordsActivity.class);
                            break;
                        case FishingTypesActivity.DRAWER_IDENTIFIER:
                            intent = new Intent(DrawerActivity.this, FishingTypesActivity.class);
                            break;
                        case HistoryActivity.DRAWER_IDENTIFIER:
                            intent = new Intent(DrawerActivity.this, HistoryActivity.class);
                            break;
                        case AboutActivity.DRAWER_IDENTIFIER:
                            intent = new Intent(DrawerActivity.this, AboutActivity.class);
                            break;

                    }
                    if (Objects.equals(intent, null)) {
                        return false;
                    }

                    startActivity(intent);
                    return true;
                })
                .build();
    }

    protected abstract Toolbar getDrawerToolbar();

    protected abstract int getDrawerItemIdentification();

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mDrawer.closeDrawer();
    }
}
