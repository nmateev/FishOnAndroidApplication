package com.mateev.fishon.views.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.mateev.fishon.R;

public class EarlyHistoryFragment extends Fragment implements IdentifiableFragment {
    private TextView mEarlyHistoryTextView;

    public EarlyHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_early_history, container, false);
        mEarlyHistoryTextView = view.findViewById(R.id.tv_history_text_view);
        mEarlyHistoryTextView.setText("Early information");

        return view;
    }

    public static EarlyHistoryFragment createNewInstance() {
        return new EarlyHistoryFragment();
    }

    public void setText(String text) {
        mEarlyHistoryTextView.setText(text);
    }

    @Override
    public String getName() {
        return "EARLY HISTORY";
    }

}