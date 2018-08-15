package com.mateev.fishon.views.locatons.wishlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.Toast;

import com.mateev.fishon.R;
import com.mateev.fishon.models.Location;
import com.mateev.fishon.views.drawerbase.DrawerActivity;
import com.mateev.fishon.views.locatons.AddNewLocationActivity;
import com.mateev.fishon.views.locatons.LocationConvertibleListViewFragment;

import java.util.ArrayList;

public class WishListActivity extends DrawerActivity implements View.OnClickListener {
    private static final String ADD_NEW_PLACE_TO_WISH_LIST_TIP_MESSAGE = "You can add a new place to your wish list by clicking the plus icon.";
    public static final int DRAWER_IDENTIFIER = 2;
    private Toolbar mDrawerToolbar;
    private ImageButton mAddLocationToWishListImageButton;
    private AlphaAnimation mImageButtonClickAnimation;
    private ArrayList<Location> mWishListLocations;
    LocationConvertibleListViewFragment mWishListLocationsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);
        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
        mAddLocationToWishListImageButton = findViewById(R.id.ib_add_new_place_to_wish_list);
        mImageButtonClickAnimation = new AlphaAnimation(1F, 0.3F);
        mAddLocationToWishListImageButton.setOnClickListener(this);

        mWishListLocations = new ArrayList<>();
        getWishListPlacesFromDatabase();

        mWishListLocationsFragment = LocationConvertibleListViewFragment.createNewInstance();
        mWishListLocationsFragment.setLocationsList(mWishListLocations);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fr_wish_list_locations_list_view, mWishListLocationsFragment)
                .commit();

        Toast.makeText(this, ADD_NEW_PLACE_TO_WISH_LIST_TIP_MESSAGE, Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onClick(View view) {
        view.startAnimation(mImageButtonClickAnimation);
        Intent intent = new Intent(this, AddNewLocationActivity.class);
        startActivity(intent);
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mDrawerToolbar;
    }

    @Override
    protected int getDrawerItemIdentification() {
        return DRAWER_IDENTIFIER;
    }

    private void getWishListPlacesFromDatabase() {

        mWishListLocations.add(new Location("Russia", "Umba", "River"));
        mWishListLocations.add(new Location("Ireland", "Lough Currane", "Lake"));
        mWishListLocations.add(new Location("Bulgaria", "Tundja", "River"));
        mWishListLocations.add(new Location("Slovenia", "Sava Bohinjka", "River"));
        mWishListLocations.add(new Location("England", "Chalk Streams", "River"));
        mWishListLocations.add(new Location("Bulgaria", "Iskar", "River"));
        mWishListLocations.add(new Location("Venezuela", "La Guaira", "Sea"));
        mWishListLocations.add(new Location("Bulgaria", "Ogosta", "River"));

    }
}
