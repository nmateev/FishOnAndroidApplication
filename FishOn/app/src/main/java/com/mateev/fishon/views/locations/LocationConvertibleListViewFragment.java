package com.mateev.fishon.views.locations;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mateev.fishon.R;
import com.mateev.fishon.models.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class LocationConvertibleListViewFragment extends Fragment{

    private List<Location> mLocationsList;
    private ListView mLocationsListView;
    private ArrayAdapter<Location> mLocationsArrayAdapter;

    public LocationConvertibleListViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location_convertible_list_view, container, false);

        mLocationsListView = view.findViewById(R.id.lv_locations_list);
        mLocationsArrayAdapter = initArrayAdapter();
        mLocationsListView.setAdapter(mLocationsArrayAdapter);

        return view;
    }

    public static LocationConvertibleListViewFragment createNewInstance() {
        return new LocationConvertibleListViewFragment();
    }

    public void setLocationsList(ArrayList<Location> locations) {

        this.mLocationsList = locations;

    }

    public ArrayAdapter<Location> initArrayAdapter() {


        return new ArrayAdapter<Location>(getContext(), android.R.layout.simple_list_item_1, mLocationsList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = convertView;
                if (Objects.equals(view, null)) {
                    LayoutInflater inflater = LayoutInflater.from(this.getContext());
                    view = inflater.inflate(R.layout.item_location_view, parent, false);
                }

                TextView mCountryName = Objects
                        .requireNonNull(view)
                        .findViewById(R.id.tv_country_name);
                TextView mWaterBasinName = view.findViewById(R.id.tv_water_basin_name);
                TextView mWaterBasinType = view.findViewById(R.id.tv_water_basin_type);
                Location mLocationAtPosition = this.getItem(position);

                String countryName = Objects
                        .requireNonNull(mLocationAtPosition)
                        .getCountry();
                String waterBasinName = mLocationAtPosition
                        .getWaterBasinName();
                String waterBasinType = mLocationAtPosition
                        .getWaterBasinType();

                mCountryName
                        .setText(countryName);
                mWaterBasinName
                        .setText(waterBasinName);
                mWaterBasinType
                        .setText(waterBasinType);

                return view;
            }
        };
    }
}
