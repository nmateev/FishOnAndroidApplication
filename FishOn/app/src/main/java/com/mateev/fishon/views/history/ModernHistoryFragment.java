package com.mateev.fishon.views.history;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mateev.fishon.R;

public class ModernHistoryFragment extends Fragment implements IdentifiableFragment {
    private TextView mModernHistoryTextView;

    public ModernHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_modern_history, container, false);
        mModernHistoryTextView = view.findViewById(R.id.tv_history_text_view);
        mModernHistoryTextView.setText("Modern information");

        return view;
    }

    @Override
    public String getName() {
        return "MODERN";
    }

    public static ModernHistoryFragment createNewInstance() {
        return new ModernHistoryFragment();
    }
}
