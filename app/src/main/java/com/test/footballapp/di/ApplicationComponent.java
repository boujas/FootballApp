package com.test.footballapp.di;

import com.test.footballapp.MainApplication;
import com.test.footballapp.di.modules.ApplicationModule;
import com.test.footballapp.di.modules.NetModule;
import com.test.footballapp.ui.presenter.LeagueTablePresenter;
import com.test.footballapp.ui.presenter.LeaguesPresenter;
import com.test.footballapp.ui.presenter.TeamsPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules ={ApplicationModule.class, NetModule.class })
public interface ApplicationComponent {

    void inject(MainApplication application);

    void inject(LeaguesPresenter leaguesPresenter);

    void inject(TeamsPresenter teamsPresenter);

    void inject(LeagueTablePresenter leagueTablePresenter);

}
