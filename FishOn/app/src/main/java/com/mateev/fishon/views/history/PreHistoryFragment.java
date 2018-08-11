package com.mateev.fishon.views.history;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mateev.fishon.R;

public class PreHistoryFragment extends Fragment implements IdentifiableFragment {
    private TextView mPreHistoryTextView;

    public PreHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pre_history, container, false);
        mPreHistoryTextView = view.findViewById(R.id.tv_history_text_view);
        mPreHistoryTextView.setText("Pre information");
        return view;

    }

    public static PreHistoryFragment createNewInstance() {
        return new PreHistoryFragment();
    }

    @Override
    public String getName() {
        return "PRE";
    }
}
