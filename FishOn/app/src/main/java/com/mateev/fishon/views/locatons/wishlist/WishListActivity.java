package com.mateev.fishon.views.locatons.wishlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.Toast;

import com.mateev.fishon.FishOnApp;
import com.mateev.fishon.R;
import com.mateev.fishon.models.Location;
import com.mateev.fishon.models.WishListLocation;
import com.mateev.fishon.repository.RepositoryBase;
import com.mateev.fishon.views.drawerbase.DrawerActivity;
import com.mateev.fishon.views.locatons.AddNewLocationActivity;
import com.mateev.fishon.views.locatons.LocationConvertibleListViewFragment;

import java.util.ArrayList;
import java.util.Objects;

public class WishListActivity extends DrawerActivity implements View.OnClickListener {
    private static final String ADD_NEW_PLACE_TO_WISH_LIST_TIP_MESSAGE = "You can add a new place to your wish list by clicking the plus icon.";
    private static final String ADD_LOCATION_LIST_KEY = "list-identifier";
    private static final String ADD_LOCATION_LIST_VALUE = "wish-list";
    public static final int DRAWER_IDENTIFIER = 2;
    private Toolbar mDrawerToolbar;
    private ImageButton mAddLocationToWishListImageButton;
    private AlphaAnimation mImageButtonClickAnimation;
    private ArrayList<Location> mWishListLocations;
    private LocationConvertibleListViewFragment mWishListLocationsFragment;
    private RepositoryBase<WishListLocation> mWishListLocationsRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);
        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
        mAddLocationToWishListImageButton = findViewById(R.id.ib_add_new_place_to_wish_list);
        mImageButtonClickAnimation = new AlphaAnimation(1F, 0.3F);
        mAddLocationToWishListImageButton.setOnClickListener(this);

        mWishListLocations = new ArrayList<>();

        mWishListLocationsRepository = FishOnApp.getWishListLocationsRepository();
        getWishListPlacesFromDatabase();

        mWishListLocationsFragment = LocationConvertibleListViewFragment.createNewInstance();
        mWishListLocationsFragment.setLocationsList(mWishListLocations);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fr_wish_list_locations_list_view, mWishListLocationsFragment)
                .commit();
        if (Objects.equals(savedInstanceState, null)) {
            Toast.makeText(this, ADD_NEW_PLACE_TO_WISH_LIST_TIP_MESSAGE, Toast.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public void onClick(View view) {
        view.startAnimation(mImageButtonClickAnimation);
        Intent intent = new Intent(this, AddNewLocationActivity.class);
        intent.putExtra(ADD_LOCATION_LIST_KEY,ADD_LOCATION_LIST_VALUE);
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

        mWishListLocationsRepository
                .getAll(wishListLocations -> {
                    wishListLocations
                            .forEach(wishListLocation -> {
                                mWishListLocations.add(wishListLocation);
                            });
                });

       /* mWishListLocations.add(new WishListLocation("Russia", "Umba", "River"));
        mWishListLocations.add(new WishListLocation("Ireland", "Lough Currane", "Lake"));
        mWishListLocations.add(new WishListLocation("Bulgaria", "Tundja", "River"));
        mWishListLocations.add(new WishListLocation("Slovenia", "Sava Bohinjka", "River"));
        mWishListLocations.add(new WishListLocation("England", "Chalk Streams", "River"));
        mWishListLocations.add(new WishListLocation("Bulgaria", "Iskar", "River"));
        mWishListLocations.add(new WishListLocation("Venezuela", "La Guaira", "Sea"));
        mWishListLocations.add(new WishListLocation("Bulgaria", "Ogosta", "River"));*/

    }

}
