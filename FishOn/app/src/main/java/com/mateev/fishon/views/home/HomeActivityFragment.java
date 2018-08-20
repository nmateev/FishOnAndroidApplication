package com.mateev.fishon.views.home;

import android.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.mateev.fishon.FishOnApp;
import com.mateev.fishon.R;
import com.mateev.fishon.models.Quote;
import com.mateev.fishon.repository.RepositoryBase;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class HomeActivityFragment extends Fragment {
    private static final float FROM_ALPHA_ANIMATION = 1F;
    private static final float TO_ALPHA_ANIMATION = 0.3F;
    private static final String SAVED_QUOTES_KEY = "saved_fishing_quotes";
    private static final String CURRENT_QUOTE_KEY = "current_quote";
    private Button mQuoteButton;
    private TextView mQuoteTextView;
    private AlphaAnimation mButtonClickAnimation;
    private static ArrayList<Quote> sFishingQuotesList;
    private RepositoryBase<Quote> mQuotesRepository;

    public HomeActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_home_activity, container, false);

        mQuoteTextView = root.findViewById(R.id.tv_quote_text);
        mQuoteButton = root.findViewById(R.id.btn_fish_for_quote);
        mButtonClickAnimation = new AlphaAnimation(FROM_ALPHA_ANIMATION, TO_ALPHA_ANIMATION);

        if (Objects.equals(savedInstanceState, null)) {
            sFishingQuotesList = new ArrayList<>();
            mQuotesRepository = FishOnApp.getQuotesRepository();
            mQuotesRepository.getAll(sFishingQuotesList::addAll);
            mQuoteTextView.setText(getString(R.string.initial_fishing_quote));
        } else {
            try {
                sFishingQuotesList = (ArrayList<Quote>) savedInstanceState.getSerializable(SAVED_QUOTES_KEY);
            } catch (ClassCastException cce) {
                sFishingQuotesList = new ArrayList<>();
                mQuotesRepository.getAll(sFishingQuotesList::addAll);
            }
            String savedQuote = savedInstanceState.getString(CURRENT_QUOTE_KEY);
            mQuoteTextView.setText(savedQuote);
        }


        mQuoteButton.setOnClickListener(view -> {
            view.startAnimation(mButtonClickAnimation);

            String nextQuote = prepareNextQuote();
            mQuoteTextView.setText(nextQuote);
        });

        return root;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(SAVED_QUOTES_KEY, sFishingQuotesList);
        outState.putString(CURRENT_QUOTE_KEY, mQuoteTextView.getText().toString());

    }

    public static HomeActivityFragment createNewInstance() {
        return new HomeActivityFragment();
    }


    private static String prepareNextQuote() {
        int randIndex = getRandomQuoteIndex();
        String quote = sFishingQuotesList
                .get(randIndex)
                .getQuoteText();
        String author = sFishingQuotesList
                .get(randIndex)
                .getAuthor();
        return new StringBuilder()
                .append(quote)
                .append("\n\n\t\t\t\t")
                .append(author).toString();
    }

    private static int getRandomQuoteIndex() {

        Random random = new Random();
        return random.nextInt(sFishingQuotesList.size());
    }
}

