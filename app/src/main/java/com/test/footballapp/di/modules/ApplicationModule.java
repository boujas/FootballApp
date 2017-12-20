package com.test.footballapp.di.modules;

import android.app.Application;

import com.test.footballapp.MainApplication;
import com.test.footballapp.storage.DatabaseRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final MainApplication application;

    public ApplicationModule(MainApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application application() {
        return application;
    }

    @Provides
    @Singleton
    DatabaseRepository provideDbRepository() {
        return new DatabaseRepository();
    }

}