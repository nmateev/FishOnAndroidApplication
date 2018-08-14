package com.mateev.fishon.views.personalrecords;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mateev.fishon.R;
import com.mateev.fishon.utilities.FishRecordInputValidator;
import com.mateev.fishon.views.drawerbase.DrawerActivity;

public class AddNewFishRecordActivity extends DrawerActivity implements View.OnClickListener {
    private static final String SUCCESSFUL_ADD_OF_FISH_RECORD_MESSAGE = "Your fish record was added successfully!\nCongratulations on the catch!";
    private static final String INVALID_SPECIES_INPUT_MESSAGE = "You should enter a valid species!";
    private static final String INVALID_COUNTRY_INPUT_MESSAGE = "You should enter a valid country!";
    private static final String INVALID_YEAR_CAUGHT_INPUT_MESSAGE = "You should enter a valid year!";
    private static final String INVALID_WEIGHT_INPUT_MESSAGE = "You should enter a valid weight!";
    private static final String INVALID_LENGTH_INPUT_MESSAGE = "You should enter a valid length!";
    private Toolbar mDrawerToolbar;
    private EditText mSpeciesEditText;
    private EditText mCountryEditText;
    private EditText mYearCaughtEditText;
    private EditText mWeightEditText;
    private EditText mLengthEditText;
    private Button mAddFishRecordButton;
    private AlphaAnimation mButtonClickAnimation;
    private FishRecordInputValidator mValidator = new FishRecordInputValidator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_fish_record);
        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
        mSpeciesEditText = findViewById(R.id.et_add_fish_species_field);
        mCountryEditText = findViewById(R.id.et_add_country_caught__field);
        mYearCaughtEditText = findViewById(R.id.et_add_year_caught_field);
        mWeightEditText = findViewById(R.id.et_add_weight_field);
        mLengthEditText = findViewById(R.id.et_add_length_field);
        mAddFishRecordButton = findViewById(R.id.btn_add_fish_record);
        mButtonClickAnimation = new AlphaAnimation(1F, 0.3F);

        mAddFishRecordButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        boolean isInputDataCorrect = true;
        view.startAnimation(mButtonClickAnimation);
        String speciesInput = mSpeciesEditText.getText().toString();
        if (!mValidator.isStringValid(speciesInput)) {
            isInputDataCorrect = false;
            Toast.makeText(this, INVALID_SPECIES_INPUT_MESSAGE, Toast.LENGTH_SHORT)
                    .show();
        }
        String countryInput = mCountryEditText.getText().toString();
        if (!mValidator.isStringValid(countryInput)) {
            isInputDataCorrect = false;
            Toast.makeText(this, INVALID_COUNTRY_INPUT_MESSAGE, Toast.LENGTH_SHORT)
                    .show();
        }
        String yearCaught = mYearCaughtEditText.getText().toString();
        if (!mValidator.isInputYearValid(yearCaught)) {
            isInputDataCorrect = false;
            Toast.makeText(this, INVALID_YEAR_CAUGHT_INPUT_MESSAGE, Toast.LENGTH_SHORT)
                    .show();
        }
        String weight = mWeightEditText.getText().toString();

        if (!mValidator.isDecimalNumberValid(weight)) {
            isInputDataCorrect = false;
            Toast.makeText(this, INVALID_WEIGHT_INPUT_MESSAGE, Toast.LENGTH_SHORT)
                    .show();
        }
        String length = mLengthEditText.getText().toString();
        if (!mValidator.isDecimalNumberValid(length)) {
            isInputDataCorrect = false;
            Toast.makeText(this, INVALID_LENGTH_INPUT_MESSAGE, Toast.LENGTH_SHORT)
                    .show();
        }

        if (isInputDataCorrect) {
            Toast.makeText(this,
                    SUCCESSFUL_ADD_OF_FISH_RECORD_MESSAGE,
                    Toast.LENGTH_LONG)
                    .show();

            // to do add it to firebase database
        }

    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mDrawerToolbar;
    }

    @Override
    protected long getItemIdentification() {
        return -1;
    }

}
