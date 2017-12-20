package com.test.footballapp.ui.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.test.footballapp.di.Injector;
import com.test.footballapp.network.RestApi;
import com.test.footballapp.ui.base.BasePresenter;
import com.test.footballapp.ui.view.TeamsView;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class TeamsPresenter extends BasePresenter<TeamsView> {

    @Inject
    RestApi mApi;

    private String mTeamId;

    public TeamsPresenter() {
        Injector.getApplicationComponent().inject(this);
    }

    public void init(String teamId) {
        mTeamId = teamId;
        getTeams();
    }

    private void getTeams() {
        Subscription subscription = mApi.getTeams(mTeamId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        teams -> {
                            if (teams == null)
                                getViewState().goBack();
                            else
                                getViewState().updateData(teams.getTeams());
                        },
                        throwable -> getViewState().onError(throwable.getMessage())
                );
        unsubscribeOnDestroy(subscription);
    }

}