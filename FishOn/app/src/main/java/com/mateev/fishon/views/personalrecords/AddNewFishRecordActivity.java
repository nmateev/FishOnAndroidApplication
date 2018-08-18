package com.mateev.fishon.views.personalrecords;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mateev.fishon.FishOnApp;
import com.mateev.fishon.R;
import com.mateev.fishon.models.FishRecord;
import com.mateev.fishon.repository.RepositoryBase;
import com.mateev.fishon.utilities.FishRecordInputValidator;
import com.mateev.fishon.views.drawerbase.DrawerActivity;

public class AddNewFishRecordActivity extends DrawerActivity implements View.OnClickListener {
    private static final String SUCCESSFUL_ADD_OF_FISH_RECORD_MESSAGE = "Your fish record was added successfully!\nCongratulations on the catch!";
    private static final String INVALID_SPECIES_INPUT_MESSAGE = "You should enter a valid species!";
    private static final String INVALID_COUNTRY_INPUT_MESSAGE = "You should enter a valid country!";
    private static final String INVALID_YEAR_CAUGHT_INPUT_MESSAGE = "You should enter a valid year!";
    private static final String INVALID_WEIGHT_INPUT_MESSAGE = "You should enter a valid weight!";
    private static final String INVALID_LENGTH_INPUT_MESSAGE = "You should enter a valid length!";
    private static final float FROM_ALPHA_ANIMATION = 1F;
    private static final float TO_ALPHA_ANIMATION = 0.3F;
    private Toolbar mDrawerToolbar;
    private EditText mSpeciesEditText;
    private EditText mCountryEditText;
    private EditText mYearCaughtEditText;
    private EditText mWeightEditText;
    private EditText mLengthEditText;
    private Button mAddFishRecordButton;
    private AlphaAnimation mButtonClickAnimation;
    private FishRecordInputValidator mValidator;
    private RepositoryBase<FishRecord> mFishRecordRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_fish_record);

        mValidator = new FishRecordInputValidator();
        mFishRecordRepository = FishOnApp.getFishRecordsRepository();
        mDrawerToolbar = findViewById(R.id.t_drawer_toolbar);
        mSpeciesEditText = findViewById(R.id.et_add_fish_species_field);
        mCountryEditText = findViewById(R.id.et_add_country_caught__field);
        mYearCaughtEditText = findViewById(R.id.et_add_year_caught_field);
        mWeightEditText = findViewById(R.id.et_add_weight_field);
        mLengthEditText = findViewById(R.id.et_add_length_field);
        mAddFishRecordButton = findViewById(R.id.btn_add_fish_record);
        mButtonClickAnimation = new AlphaAnimation(FROM_ALPHA_ANIMATION, TO_ALPHA_ANIMATION);

        mAddFishRecordButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        view.startAnimation(mButtonClickAnimation);

        boolean isUserInputDataCorrect = true;

        String speciesInput = mSpeciesEditText.getText().toString();
        if (!mValidator.isStringValid(speciesInput)) {
            isUserInputDataCorrect = false;
            Toast.makeText(this, INVALID_SPECIES_INPUT_MESSAGE, Toast.LENGTH_SHORT)
                    .show();
        }
        String countryInput = mCountryEditText.getText().toString();
        if (!mValidator.isStringValid(countryInput)) {
            isUserInputDataCorrect = false;
            Toast.makeText(this, INVALID_COUNTRY_INPUT_MESSAGE, Toast.LENGTH_SHORT)
                    .show();
        }
        String yearCaughtInput = mYearCaughtEditText.getText().toString();
        if (!mValidator.isInputYearValid(yearCaughtInput)) {
            isUserInputDataCorrect = false;
            Toast.makeText(this, INVALID_YEAR_CAUGHT_INPUT_MESSAGE, Toast.LENGTH_SHORT)
                    .show();
        }
        String weightInput = mWeightEditText.getText().toString();

        if (!mValidator.isDecimalNumberValid(weightInput)) {
            isUserInputDataCorrect = false;
            Toast.makeText(this, INVALID_WEIGHT_INPUT_MESSAGE, Toast.LENGTH_SHORT)
                    .show();
        }
        String lengthInput = mLengthEditText.getText().toString();
        if (!mValidator.isDecimalNumberValid(lengthInput)) {
            isUserInputDataCorrect = false;
            Toast.makeText(this, INVALID_LENGTH_INPUT_MESSAGE, Toast.LENGTH_SHORT)
                    .show();
        }

        if (isUserInputDataCorrect) {

            FishRecord newFishRecord = new FishRecord(speciesInput,
                    yearCaughtInput,
                    countryInput,
                    Double.parseDouble(lengthInput),
                    Double.parseDouble(weightInput));

            mFishRecordRepository.add(newFishRecord);

            Toast.makeText(this,
                    SUCCESSFUL_ADD_OF_FISH_RECORD_MESSAGE,
                    Toast.LENGTH_LONG)
                    .show();
        }

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
