package com.mateev.fishon.repository;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import java.util.List;
import java.util.function.Consumer;

public class FirebaseRepository<T> implements RepositoryBase<T> {
    private final FirebaseFirestore mDb;
    private FirebaseFirestoreSettings settings;
    private final Class<T> mKlass;
    private String mCollectionName;


    public FirebaseRepository(Class<T> klass) {
        mDb = FirebaseFirestore.getInstance();
        settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        mDb.setFirestoreSettings(settings);

        mKlass = klass;
        mCollectionName = mKlass
                .getSimpleName()
                .toLowerCase() + "s";
    }


    @Override
    public void getAll(Consumer<List<T>> action) {
        mDb.collection(mCollectionName)
                .get()
                .addOnCompleteListener(task -> {
                    List<T> items = task
                            .getResult()
                            .toObjects(mKlass);
                    action.accept(items);
                });

    }

    @Override
    public void add(T item, Consumer<T> action) {
        mDb.collection(mCollectionName)
                .add(item)
                .addOnCompleteListener(task -> action.accept(item));

    }

    @Override
    public void add(T item) {
        mDb.collection(mCollectionName)
                .add(item);
    }
}

