package com.mateev.fishon.views.personalrecords;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.mateev.fishon.R;
import com.mateev.fishon.models.FishRecord;
import com.sdsmdg.tastytoast.TastyToast;


public class DetailedFishRecordActivity extends AppCompatActivity implements View.OnTouchListener {
    private static final String ON_CUSTOM_VIEW_TOUCH_MESSAGE = "Brings back memories!";
    private static final String CLICKED_FISH_EXTRA_KEY = "clicked-fish";
    private static final String COUNTRY_NAME_FIELD = "Country: ";
    private static final String YEAR_CAUGHT_FIELD = "Year caught: ";
    private static final String WEIGHT_FIELD = "Weight: ";
    private static final String LENGTH_FIELD = "Length: ";
    private static final String WEIGHT_UNITS = " kg";
    private static final String LENGTH_UNITS = " cm";
    private TextView mFishFieldCountry;
    private TextView mFishFieldYearCaught;
    private TextView mFishFieldWeight;
    private TextView mFishFieldLenght;
    private TextView mFishInfoCountry;
    private TextView mFishInfoYearCaught;
    private TextView mFishInfoWeight;
    private TextView mFishInfoLenght;
    private CustomView mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_fish_record);

        Intent intent = getIntent();

        FishRecord clickedFishRecordExtra = (FishRecord) intent.getSerializableExtra(CLICKED_FISH_EXTRA_KEY);
        mCustomView = findViewById(R.id.cv_custom_view);
        mCustomView.setSpeciesNameToDraw(clickedFishRecordExtra.getSpeciesName());

        mFishFieldCountry = findViewById(R.id.tv_fish_country_field);
        mFishFieldYearCaught = findViewById(R.id.tv_fish_year_caught_field);
        mFishFieldWeight = findViewById(R.id.tv_fish_weight_field);
        mFishFieldLenght = findViewById(R.id.tv_fish_length_field);

        mFishFieldCountry.setText(COUNTRY_NAME_FIELD);
        mFishFieldYearCaught.setText(YEAR_CAUGHT_FIELD);
        mFishFieldWeight.setText(WEIGHT_FIELD);
        mFishFieldLenght.setText(LENGTH_FIELD);

        mFishInfoCountry = findViewById(R.id.tv_fish_country_info);
        mFishInfoYearCaught = findViewById(R.id.tv_fish_year_caught_info);
        mFishInfoWeight = findViewById(R.id.tv_fish_weight_info);
        mFishInfoLenght = findViewById(R.id.tv_fish_length_info);

        mFishInfoCountry
                .setText(clickedFishRecordExtra.getCountryCaught());
        mFishInfoYearCaught
                .setText(clickedFishRecordExtra.getYearCaught());
        mFishInfoWeight.setText(new StringBuilder()
                .append(clickedFishRecordExtra.getWeight())
                .append(WEIGHT_UNITS).toString());

        mFishInfoLenght.setText(new StringBuilder()
                .append(clickedFishRecordExtra.getLength())
                .append(LENGTH_UNITS).toString());


        mCustomView.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        TastyToast
                .makeText(this,
                        ON_CUSTOM_VIEW_TOUCH_MESSAGE,
                        TastyToast.LENGTH_SHORT,
                        TastyToast.CONFUSING).show();
        return true;

    }
}
