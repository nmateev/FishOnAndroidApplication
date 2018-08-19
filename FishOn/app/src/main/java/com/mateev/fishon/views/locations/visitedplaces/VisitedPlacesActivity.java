package com.mateev.fishon.views.locations.visitedplaces;

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
import com.mateev.fishon.models.VisitedLocation;
import com.mateev.fishon.repository.RepositoryBase;
import com.mateev.fishon.views.drawerbase.DrawerActivity;
import com.mateev.fishon.views.locations.AddNewLocationActivity;
import com.mateev.fishon.views.locations.LocationConvertibleListViewFragment;

import java.util.ArrayList;
import java.util.Objects;

public class VisitedPlacesActivity extends DrawerActivity implements View.OnClickListener {
    private static final String ADD_NEW_VISITED_PLACE_TIP_MESSAGE = "You can add a new visited place by clicking the plus icon.";
    private static final String ADD_LOCATION_LIST_KEY = "list-identifier";
    private static final String ADD_LOCATION_LIST_VALUE = "visited-list";
    public static final int DRAWER_IDENTIFIER = 3;
    private static final float FROM_ALPHA_ANIMATION = 1F;
    private static final float TO_ALPHA_ANIMATION = 0.3F;
    private Toolbar mDrawerToolbar;
    private ImageButton mAddVisitedPlaceImageButton;
    private AlphaAnimation mImageButtonClickAnimation;
    private LocationConvertibleListViewFragment mVisitedLocationsFragment;
    private ArrayList<Location> mVisitedLocationsList;
    private RepositoryBase<VisitedLocation> mVisitedLocationsRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mVisitedLocationsList = new ArrayList<>();
        mVisitedLocationsRepository = FishOnApp.getVisitedLocationsRepository();
        getVisitedPlacesFromDatabase();

        setContentView(R.layout.activity_visited_places);
        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
        mAddVisitedPlaceImageButton = findViewById(R.id.ib_add_new_visited_place);
        mImageButtonClickAnimation = new AlphaAnimation(FROM_ALPHA_ANIMATION, TO_ALPHA_ANIMATION);
        mAddVisitedPlaceImageButton.setOnClickListener(this);


        mVisitedLocationsFragment = LocationConvertibleListViewFragment.createNewInstance();
        mVisitedLocationsFragment.setLocationsList(mVisitedLocationsList);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fr_visited_locations_list_view, mVisitedLocationsFragment)
                .commit();

        if (Objects.equals(savedInstanceState, null)) {
            Toast.makeText(this, ADD_NEW_VISITED_PLACE_TIP_MESSAGE, Toast.LENGTH_LONG)
                    .show();
        }


    }

    @Override
    public void onClick(View view) {
        view.startAnimation(mImageButtonClickAnimation);

        Intent intent = new Intent(this, AddNewLocationActivity.class);
        intent.putExtra(ADD_LOCATION_LIST_KEY, ADD_LOCATION_LIST_VALUE);
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


    private void getVisitedPlacesFromDatabase() {

        mVisitedLocationsRepository.getAll(visitedLocations -> {
            visitedLocations.forEach(visitedLocation -> {
                mVisitedLocationsList.add(visitedLocation);
            });
        });

       /* mVisitedLocationsList.add(new VisitedLocation("Bulgaria", "Danube", "River"));
        mVisitedLocationsList.add(new VisitedLocation("UK", "Meon", "River"));
        mVisitedLocationsList.add(new VisitedLocation("Bulgaria", "Veleka", "River"));
        mVisitedLocationsList.add(new VisitedLocation("Bulgaria", "Vucha", "River"));
        mVisitedLocationsList.add(new VisitedLocation("Bulgaria", "Black Sea", "Sea"));
        mVisitedLocationsList.add(new VisitedLocation("Canada", "Great bear lake", "Lake"));
        mVisitedLocationsList.add(new VisitedLocation("Bulgaria", "Zlatna Panega", "River"));
        mVisitedLocationsList.add(new VisitedLocation("Bulgaria", "Batuliiska", "River"));
        mVisitedLocationsList.add(new VisitedLocation("Russia", "Baikal", "Lake"));
        mVisitedLocationsList.add(new VisitedLocation("Bulgaria", "Struma", "River"));
        mVisitedLocationsList.add(new VisitedLocation("Bulgaria", "Lom", "River"));
        mVisitedLocationsList.add(new VisitedLocation("Bulgaria", "Eleshnitsa", "River"));
        mVisitedLocationsList.add(new VisitedLocation("Bulgaria", "Bqla reka", "River"));
        mVisitedLocationsList.add(new VisitedLocation("U.S", "Table Rock Lake", "Lake"));
        mVisitedLocationsList.add(new VisitedLocation("Bulgaria", "Belitsa", "River"));
        mVisitedLocationsList.add(new VisitedLocation("Bulgaria", "Breznishka", "River"));*/

    }
}
