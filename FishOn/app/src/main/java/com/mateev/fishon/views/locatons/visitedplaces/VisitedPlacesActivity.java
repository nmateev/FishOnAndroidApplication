package com.mateev.fishon.views.locatons.visitedplaces;

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

public class VisitedPlacesActivity extends DrawerActivity implements View.OnClickListener {
    private static final String ADD_NEW_VISITED_PLACE_TIP_MESSAGE = "You can add a new visited place by clicking the plus icon.";
    private Toolbar mDrawerToolbar;
    private ImageButton mAddVisitedPlaceImageButton;
    private AlphaAnimation mImageButtonClickAnimation;
    private ArrayList<Location> mVisitedLocationsList;
    LocationConvertibleListViewFragment mVisitedLocationsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visited_places);
        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
        mAddVisitedPlaceImageButton = findViewById(R.id.ib_add_new_visited_place);
        mImageButtonClickAnimation = new AlphaAnimation(1F, 0.3F);
        mAddVisitedPlaceImageButton.setOnClickListener(this);

        mVisitedLocationsList = new ArrayList<>();
        getVisitedPlacesFromDatabase();

        mVisitedLocationsFragment = LocationConvertibleListViewFragment.createNewInstance();
        mVisitedLocationsFragment.setLocationsList(mVisitedLocationsList);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fr_visited_locations_list_view, mVisitedLocationsFragment)
                .commit();


        Toast.makeText(this, ADD_NEW_VISITED_PLACE_TIP_MESSAGE, Toast.LENGTH_LONG)
                .show();

    }

    @Override
    public void onClick(View view) {
        view.startAnimation(mImageButtonClickAnimation);

        Intent intent = new Intent(this, AddNewLocationActivity.class);
        startActivity(intent);
        //to do new activity to add location which also will be the same like in wish list so abstract
    }


    @Override
    protected Toolbar getDrawerToolbar() {
        return mDrawerToolbar;
    }


    @Override
    protected long getItemIdentification() {
        return 3;
    }


    private void getVisitedPlacesFromDatabase() {

        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));

    }
}
