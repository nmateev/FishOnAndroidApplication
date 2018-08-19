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
    private static RepositoryBase<FishRecord> sFishRecordsRepository;
    private static RepositoryBase<WishListLocation> sWishListLocationsRepository;
    private static RepositoryBase<VisitedLocation> sVisitedLocationsRepository;
    private static RepositoryBase<Quote> sQuotesRepository;

    public static RepositoryBase<FishRecord> getFishRecordsRepository() {
        if (Objects.equals(sFishRecordsRepository, null)) {

            sFishRecordsRepository = new FirebaseRepository<>(FishRecord.class);
        }
        return sFishRecordsRepository;
    }

    public static RepositoryBase<WishListLocation> getWishListLocationsRepository() {
        if (Objects.equals(sWishListLocationsRepository, null)) {

            sWishListLocationsRepository = new FirebaseRepository<>(WishListLocation.class);
        }
        return sWishListLocationsRepository;
    }

    public static RepositoryBase<VisitedLocation> getVisitedLocationsRepository() {
        if (Objects.equals(sVisitedLocationsRepository, null)) {

            sVisitedLocationsRepository = new FirebaseRepository<>(VisitedLocation.class);
        }
        return sVisitedLocationsRepository;
    }

    public static RepositoryBase<Quote> getQuotesRepository() {
        if (Objects.equals(sQuotesRepository, null)) {

            sQuotesRepository = new FirebaseRepository<>(Quote.class);
        }
        return sQuotesRepository;
    }
}
