package com.mateev.fishon;

import android.app.Application;

import com.mateev.fishon.models.FishRecord;
import com.mateev.fishon.models.Quote;
import com.mateev.fishon.models.VisitedLocation;
import com.mateev.fishon.models.WishListLocation;
import com.mateev.fishon.repository.FirebaseRepository;
import com.mateev.fishon.repository.RepositoryBase;

import java.util.Objects;

public class FishOnApp extends Application {
    private static RepositoryBase<FishRecord> fishRecordsRepository;
    private static RepositoryBase<WishListLocation> wishListLocationsRepository;
    private static RepositoryBase<VisitedLocation> visitedLocationsRepository;
    private static RepositoryBase<Quote> quotesRepository;

    public static RepositoryBase<FishRecord> getFishRecordsRepository() {
        if (Objects.equals(fishRecordsRepository, null)) {

            fishRecordsRepository = new FirebaseRepository<>(FishRecord.class);
        }
        return fishRecordsRepository;
    }

    public static RepositoryBase<WishListLocation> getWishListLocationsRepository() {
        if (Objects.equals(wishListLocationsRepository, null)) {

            wishListLocationsRepository = new FirebaseRepository<>(WishListLocation.class);
        }
        return wishListLocationsRepository;
    }

    public static RepositoryBase<VisitedLocation> getVisitedLocationsRepository() {
        if (Objects.equals(visitedLocationsRepository, null)) {

            visitedLocationsRepository = new FirebaseRepository<>(VisitedLocation.class);
        }
        return visitedLocationsRepository;
    }

    public static RepositoryBase<Quote> getQuotesRepository() {
        if (Objects.equals(quotesRepository, null)) {

            quotesRepository = new FirebaseRepository<>(Quote.class);
        }
        return quotesRepository;
    }
}
