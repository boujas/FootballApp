package com.test.footballapp;

import android.app.Application;

import com.test.footballapp.di.Injector;

import io.realm.Realm;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
        Realm.init(this);
    }

    protected void initDagger() {
        Injector.initializeApplicationComponent(this);
        Injector.getApplicationComponent().inject(this);
    }

}