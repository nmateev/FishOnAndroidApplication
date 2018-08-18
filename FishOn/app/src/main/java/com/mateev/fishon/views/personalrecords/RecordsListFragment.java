package com.mateev.fishon.views.personalrecords;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mateev.fishon.FishOnApp;
import com.mateev.fishon.R;
import com.mateev.fishon.models.FishRecord;
import com.mateev.fishon.repository.RepositoryBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecordsListFragment extends Fragment {
    private static String CLICKED_FISH_EXTRA_KEY = "clicked-fish";
    private static String LENGTH_UNITS = " cm";
    private ListView mPersonalRecordsListView;
    private ArrayAdapter<FishRecord> mPersonalRecordsArrayAdapter;
    private static List<FishRecord> mPersonalFishRecordRecordsList;
    private RepositoryBase<FishRecord> mFishRecordRepository;

    public RecordsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_records_list, container, false);
        mFishRecordRepository = FishOnApp.getFishRecordsRepository();
        mPersonalFishRecordRecordsList = new ArrayList<>();
        getPersonalRecordsFromDatabase();

        mPersonalRecordsListView = view.findViewById(R.id.lv_personal_records_list);
        mPersonalRecordsArrayAdapter = initArrayAdapter();
        mPersonalRecordsListView.setAdapter(mPersonalRecordsArrayAdapter);

        mPersonalRecordsListView.setOnItemClickListener((parent, currentView, position, id) -> {

            FishRecord clickedFishRecord = mPersonalRecordsArrayAdapter.getItem(position);
            Intent intent = new Intent(getContext(), DetailedFishRecordActivity.class);
            intent.putExtra(CLICKED_FISH_EXTRA_KEY, clickedFishRecord);
            startActivity(intent);
        });

        return view;

    }


    public static RecordsListFragment createNewInstance() {
        return new RecordsListFragment();
    }

    private ArrayAdapter<FishRecord> initArrayAdapter() {

        return new ArrayAdapter<FishRecord>(getContext(), android.R.layout.simple_list_item_1, mPersonalFishRecordRecordsList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = convertView;
                if (Objects.equals(view, null)) {
                    LayoutInflater inflater = LayoutInflater.from(this.getContext());
                    view = inflater.inflate(R.layout.item_fish_record_view, parent, false);
                }
                TextView mSpeciesName = view.findViewById(R.id.tv_fish_species);
                TextView mFishLength = view.findViewById(R.id.tv_fish_length);
                FishRecord mFishRecordAtPosition = this.getItem(position);

                String fishSpecies = mFishRecordAtPosition.getSpeciesName();
                double fishLength = mFishRecordAtPosition.getLength();

                mSpeciesName.setText(fishSpecies);
                mFishLength.setText(new StringBuilder()
                        .append(fishLength)
                        .append(LENGTH_UNITS)
                        .toString());

                return view;
            }
        };
    }


    private void getPersonalRecordsFromDatabase() {

        mFishRecordRepository
                .getAll(personalFishRecords -> {
                    personalFishRecords.forEach(personalFishRecord->{
                        mPersonalFishRecordRecordsList.add(personalFishRecord);
                    });
                });


      /*  mPersonalFishRecordRecordsList.add(new FishRecord("Trout", "2017", "Bulgaria", 30.2, 0.450));
        mPersonalFishRecordRecordsList.add(new FishRecord("Barbus", "2018", "Bulgaria", 26.3, 0.220));
        mPersonalFishRecordRecordsList.add(new FishRecord("Bleak", "2011", "Bulgaria", 15, 0.050));
        mPersonalFishRecordRecordsList.add(new FishRecord("Carp", "2013", "Bulgaria", 56, 6.724));
        mPersonalFishRecordRecordsList.add(new FishRecord("Perch", "2018", "Bulgaria", 20.1, 0.100));
        mPersonalFishRecordRecordsList.add(new FishRecord("Salmon", "2015", "Russia", 48, 2.860));
        mPersonalFishRecordRecordsList.add(new FishRecord("Dace", "2016", "Bulgaria", 28.9, 0.390));
        mPersonalFishRecordRecordsList.add(new FishRecord("Catfish", "2014", "Bulgaria", 112.5, 92.900));*/

    }
}