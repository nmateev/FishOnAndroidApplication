package com.mateev.fishon.views.locatons.visitedplaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
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
    public static final int DRAWER_IDENTIFIER = 3;
    private static final float FROM_ALPHA_ANIMATION = 1F;
    private static final float TO_ALPHA_ANIMATION = 0.3F;
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
        mImageButtonClickAnimation = new AlphaAnimation(FROM_ALPHA_ANIMATION, TO_ALPHA_ANIMATION);
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
    protected int getDrawerItemIdentification() {
        return DRAWER_IDENTIFIER;
    }


    private void getVisitedPlacesFromDatabase() {

        mVisitedLocationsList.add(new Location("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new Location("UK", "Meon", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Veleka", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Vucha", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Black Sea", "Sea"));
        mVisitedLocationsList.add(new Location("Canada", "Great bear lake", "Lake"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Zlatna Panega", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Batuliiska", "River"));
        mVisitedLocationsList.add(new Location("Russia", "Baikal", "Lake"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Struma", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Lom", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Eleshnitsa", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Bqla reka", "River"));
        mVisitedLocationsList.add(new Location("U.S", "Table Rock Lake", "Lake"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Belitsa", "River"));
        mVisitedLocationsList.add(new Location("Bulgaria", "Breznishka", "River"));


    }
}
