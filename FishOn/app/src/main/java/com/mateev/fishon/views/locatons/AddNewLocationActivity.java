package com.mateev.fishon.views.locatons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mateev.fishon.FishOnApp;
import com.mateev.fishon.R;
import com.mateev.fishon.models.VisitedLocation;
import com.mateev.fishon.models.WishListLocation;
import com.mateev.fishon.repository.RepositoryBase;
import com.mateev.fishon.utilities.InputValidator;
import com.mateev.fishon.views.drawerbase.DrawerActivity;

public class AddNewLocationActivity extends DrawerActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private static final String INVALID_COUNTRY_INPUT_MESSAGE = "You should enter a valid country!";
    private static final String INVALID_WATER_BASIN_NAME_INPUT_MESSAGE = "You should enter a valid water basin name!";
    private static final String SUCCESSFUL_ADD_OF_NEW_WISH_LIST_LOCATION_MESSAGE = "You have successfully added this location to your wish list!";
    private static final String SUCCESSFUL_ADD_OF_NEW_VISITED_LOCATION_MESSAGE = "You have successfully added this location to your visited places!";
    private static final String ADD_WISH_LIST_LOCATION_VALUE = "wish-list";
    private static final String ADD_VISITED_LOCATION_VALUE = "visited-list";
    private static final String ADD_LOCATION_LIST_KEY = "list-identifier";
    private static final float FROM_ALPHA_ANIMATION = 1F;
    private static final float TO_ALPHA_ANIMATION = 0.3F;
    private static final int DEFAULT_SPINNER_SELECTED_ITEM = 0;
    private Toolbar mDrawerToolbar;
    private EditText mCountryEditText;
    private EditText mWaterBasinNameEditText;
    private String mWaterBasinSelection;
    private Spinner mWaterBasinTypeSpinner;
    private ArrayAdapter<CharSequence> mWaterBasinTypeAdapter;
    private Button mAddNewLocationButton;
    private InputValidator mInputValidator;
    private AlphaAnimation mButtonClickAnimation;
    private String listIdentifier;
    private RepositoryBase<WishListLocation> mWishListLocationRepository;
    private RepositoryBase<VisitedLocation> mVisitedLocationRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_location);
        mWishListLocationRepository = FishOnApp.getWishListLocationsRepository();
        mVisitedLocationRepository = FishOnApp.getVisitedLocationsRepository();
        Intent intent = getIntent();
        listIdentifier = intent
                .getStringExtra(ADD_LOCATION_LIST_KEY);

        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
        mCountryEditText = findViewById(R.id.et_add_country_field);
        mWaterBasinNameEditText = findViewById(R.id.et_add_water_basin_name_field);
        mWaterBasinTypeSpinner = findViewById(R.id.sp_water_basin_type);
        mAddNewLocationButton = findViewById(R.id.btn_add_new_location);
        mAddNewLocationButton.setOnClickListener(this);
        mInputValidator = new InputValidator();
        mButtonClickAnimation = new AlphaAnimation(FROM_ALPHA_ANIMATION, TO_ALPHA_ANIMATION);

        mWaterBasinTypeAdapter = ArrayAdapter
                .createFromResource(this, R.array.water_basin_types_array, R.layout.spinner_text_view_item);
        mWaterBasinTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mWaterBasinTypeSpinner.setAdapter(mWaterBasinTypeAdapter);
        mWaterBasinTypeSpinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onClick(View view) {
        view.startAnimation(mButtonClickAnimation);
        boolean isInputDataValid = true;

        String countryInput = mCountryEditText.getText().toString();
        if (!mInputValidator.isStringValid(countryInput)) {
            isInputDataValid = false;
            Toast.makeText(this, INVALID_COUNTRY_INPUT_MESSAGE, Toast.LENGTH_SHORT)
                    .show();
        }
        String waterBasinName = mWaterBasinNameEditText.getText().toString();
        if (!mInputValidator.isStringValid(waterBasinName)) {
            isInputDataValid = false;
            Toast.makeText(this, INVALID_WATER_BASIN_NAME_INPUT_MESSAGE, Toast.LENGTH_SHORT)
                    .show();
        }

        if (isInputDataValid) {
            String onAddSuccessMessage = null;
            switch (listIdentifier) {
                case ADD_WISH_LIST_LOCATION_VALUE:
                    WishListLocation newWishListLocation =
                            new WishListLocation(countryInput,
                                    waterBasinName,
                                    mWaterBasinSelection);

                    mWishListLocationRepository.add(newWishListLocation);
                    onAddSuccessMessage = SUCCESSFUL_ADD_OF_NEW_WISH_LIST_LOCATION_MESSAGE;
                    break;
                case ADD_VISITED_LOCATION_VALUE:
                    VisitedLocation newVisitedLocation =
                            new VisitedLocation(countryInput,
                                    waterBasinName,
                                    mWaterBasinSelection);

                    mVisitedLocationRepository.add(newVisitedLocation);
                    onAddSuccessMessage = SUCCESSFUL_ADD_OF_NEW_VISITED_LOCATION_MESSAGE;
                    break;
            }

            Toast.makeText(this,
                    onAddSuccessMessage,
                    Toast.LENGTH_LONG)
                    .show();

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mWaterBasinSelection = parent
                .getAdapter()
                .getItem(position)
                .toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        mWaterBasinSelection = parent
                .getAdapter()
                .getItem(DEFAULT_SPINNER_SELECTED_ITEM)
                .toString();
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mDrawerToolbar;
    }

    @Override
    protected int getDrawerItemIdentification() {
        //should not return valid identification
        return -1;
    }


}
