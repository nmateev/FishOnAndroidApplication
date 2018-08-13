package com.mateev.fishon.views.personalrecords;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mateev.fishon.R;
import com.mateev.fishon.models.Fish;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecordsListFragment extends Fragment {
    private static String CLICKED_FISH_EXTRA_KEY = "clicked-fish";
    private ListView mPersonalRecordsListView;
    private ArrayAdapter<Fish> mPersonalRecordsArrayAdapter;
    private List<Fish> mPersonalFishRecordsList;

    public RecordsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mPersonalFishRecordsList = new ArrayList<>();
        getPersonalRecordsFromDatabase();

        View view = inflater.inflate(R.layout.fragment_records_list, container, false);
        mPersonalRecordsListView = view.findViewById(R.id.lv_personal_records_list);
        mPersonalRecordsArrayAdapter = initArrayAdapter();
        mPersonalRecordsListView.setAdapter(mPersonalRecordsArrayAdapter);

        mPersonalRecordsListView.setOnItemClickListener((parent, currentView, position, id) -> {

            Fish clickedFish = mPersonalRecordsArrayAdapter.getItem(position);
            Intent intent = new Intent(getContext(), DetailedFishRecordActivity.class);
            intent.putExtra(CLICKED_FISH_EXTRA_KEY, clickedFish);
            startActivity(intent);
        });

        return view;

    }

    public static RecordsListFragment createNewInstance() {
        return new RecordsListFragment();
    }

    private ArrayAdapter<Fish> initArrayAdapter() {

        return new ArrayAdapter<Fish>(getContext(), android.R.layout.simple_list_item_1, mPersonalFishRecordsList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = convertView;
                if (Objects.equals(view, null)) {
                    LayoutInflater inflater = LayoutInflater.from(this.getContext());
                    view = inflater.inflate(R.layout.item_fish_record_view, parent, false);
                }
                //to do  get all information about record
                TextView mSpeciesName = view.findViewById(R.id.tv_fish_species);
                TextView mFishLength = view.findViewById(R.id.tv_fish_length);
                Fish mFishAtPosition = this.getItem(position);

                String fishSpecies = mFishAtPosition.getSpeciesName();
                double fishLength = mFishAtPosition.getLength();

                mSpeciesName.setText(fishSpecies);
                mFishLength.setText(new StringBuilder()
                        .append(fishLength)
                        .append(" ")
                        .append("cm")
                        .toString());

                return view;
            }
        };
    }

    private void getPersonalRecordsFromDatabase() {

        //to do get from firebase
        mPersonalFishRecordsList.add(new Fish("Trout", "2018", "Bulgaria", 21.3, 0.300));
        mPersonalFishRecordsList.add(new Fish("Trout", "2018", "Bulgaria", 21.3, 0.300));
        mPersonalFishRecordsList.add(new Fish("Trout", "2018", "Bulgaria", 21.3, 0.300));
        mPersonalFishRecordsList.add(new Fish("Trout", "2018", "Bulgaria", 21.3, 0.300));
        mPersonalFishRecordsList.add(new Fish("Carb", "2018", "Bulgaria", 56, 21));
        mPersonalFishRecordsList.add(new Fish("Trout", "2018", "Bulgaria", 21.3, 0.300));
        mPersonalFishRecordsList.add(new Fish("Trout", "2018", "Bulgaria", 21.3, 0.300));
        mPersonalFishRecordsList.add(new Fish("Trout", "2018", "Bulgaria", 21.3, 0.500));
        mPersonalFishRecordsList.add(new Fish("Trout", "2018", "Bulgaria", 21.3, 0.300));
        mPersonalFishRecordsList.add(new Fish("Trout", "2018", "Bulgaria", 21.3, 0.300));
        mPersonalFishRecordsList.add(new Fish("Trout", "2018", "Bulgaria", 21.3, 0.300));
        mPersonalFishRecordsList.add(new Fish("Trout", "2018", "Bulgaria", 21.3, 0.300));
        mPersonalFishRecordsList.add(new Fish("Trout", "2018", "Bulgaria", 21.3, 0.300));

    }
}
