package com.test.footballapp.storage;

import com.test.footballapp.models.League;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.Sort;
import rx.Observable;

public class DatabaseRepository {

    private static final int SCHEMA_VERSION = 1;
    private static final String SCHEMA_NAME = "default.realm";

    private RealmConfiguration configuration;

    public DatabaseRepository() {
        initRealm();
    }

    private void initRealm() {
        configuration = new RealmConfiguration.Builder()
                .name(SCHEMA_NAME)
                .schemaVersion(SCHEMA_VERSION)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);
    }

    private Realm realm() {
        return Realm.getDefaultInstance();
    }

    public void saveLeagues(List<League> leagues){
        realm().executeTransaction(realm -> realm.insertOrUpdate(leagues));
    }

    public Observable<List<League>> getLeagues(){
       return realm()
               .where(League.class)
               .findAll()
               .sort("lastUpdated", Sort.DESCENDING)
               .asObservable()
               .map(ArrayList::new);
    }

}
