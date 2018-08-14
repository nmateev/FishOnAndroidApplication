package com.mateev.fishon.views.home;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.app.Fragment;
import android.widget.TextView;

import com.mateev.fishon.R;

public class HomeActivityFragment extends Fragment {
    private static final float FROM_ALPHA_ANIMATION = 1F;
    private static final float TO_ALPHA_ANIMATION = 0.3F;
    private Button mQuoteButton;
    private TextView mQuoteTextView;
    private AlphaAnimation mButtonClickAnimation;

    public HomeActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home_activity, container, false);
        mQuoteTextView = root.findViewById(R.id.tv_quote_text);
        mQuoteTextView.setText("Initial text");
        mQuoteTextView.setMovementMethod(new ScrollingMovementMethod());
        mQuoteButton = root.findViewById(R.id.btn_fish_for_quote);
        mButtonClickAnimation = new AlphaAnimation(FROM_ALPHA_ANIMATION, TO_ALPHA_ANIMATION);
        mQuoteButton.setOnClickListener(view -> {
            view.startAnimation(mButtonClickAnimation);

            mQuoteTextView.setText("Text for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testing" +
                    "Text for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testing" +
                    "Text for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testing" +
                    "Text for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testing" +
                    "Text for testingText for testingText for testingText for testingText for testingText for testing" +
                    "Text for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testing" +
                    "Text for testingText for testingText for testingText for testingText for testingText for testing" +
                    "Text for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testing" +
                    "Text for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testingText for testing" +
                    "" +
                    "");
        });

        return root;
    }

    public static HomeActivityFragment createNewInstance() {
        return new HomeActivityFragment();
    }
}
