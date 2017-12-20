package com.test.footballapp.di;

import com.test.footballapp.MainApplication;
import com.test.footballapp.di.modules.ApplicationModule;
import com.test.footballapp.di.modules.NetModule;

public class Injector {

    private static ApplicationComponent applicationComponent;

    private Injector() {
    }

    public static void initializeApplicationComponent(MainApplication application) {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(application))
                .netModule(new NetModule())
               // .storageModule(new StorageModule(application))
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}