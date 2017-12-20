package com.test.footballapp.ui.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.test.footballapp.di.Injector;
import com.test.footballapp.network.RestApi;
import com.test.footballapp.ui.base.BasePresenter;
import com.test.footballapp.ui.view.LeagueTableView;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class LeagueTablePresenter extends BasePresenter<LeagueTableView> {

    @Inject
    RestApi mApi;

    private String mLeagueId;

    public LeagueTablePresenter() {
        Injector.getApplicationComponent().inject(this);
    }

    public void init(String id) {
        this.mLeagueId = id;
        loadStandingds();
    }

    private void loadStandingds() {
        Subscription subscription = mApi.getTable(mLeagueId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        tableResponse -> {
                            if (tableResponse == null)
                                getViewState().goBack();
                            else
                                getViewState().updateData(tableResponse.getStanding());
                        },
                        throwable -> getViewState().onError(throwable.getMessage())
                );
        unsubscribeOnDestroy(subscription);
    }

}