package com.test.footballapp.ui.presenter;

import android.os.Bundle;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.test.footballapp.di.Injector;
import com.test.footballapp.network.RestApi;
import com.test.footballapp.storage.DatabaseRepository;
import com.test.footballapp.ui.base.BasePresenter;
import com.test.footballapp.ui.fragment.LeagueTableFragment;
import com.test.footballapp.ui.fragment.TeamsFragment;
import com.test.footballapp.ui.view.LeaguesView;
import com.test.footballapp.utils.Const;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class LeaguesPresenter extends BasePresenter<LeaguesView> {

    @Inject
    RestApi mApi;
    @Inject
    DatabaseRepository mDatabaseRepository;

    private static final String TAG = "LeaguesPresenter";

    public LeaguesPresenter() {
        Injector.getApplicationComponent().inject(this);
        mDatabaseRepository = new DatabaseRepository();
    }

    public void init() {
        Subscription subscription = mDatabaseRepository.getLeagues().subscribe(
                leagues -> getViewState().updateData(leagues),
                Throwable::printStackTrace
        );
        unsubscribeOnDestroy(subscription);
        updateLeagues();
    }

    public void updateLeagues() {
        mApi.getSeason()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(seasons -> seasons != null)
                .doOnNext(seasons -> mDatabaseRepository.saveLeagues(seasons))
                .subscribe(
                        seasons ->
                                Log.d(TAG, "synced"),
                        throwable ->
                                getViewState().onError(throwable.getMessage())
                );
    }

    public void onTeamsClick(String id) {
        TeamsFragment fragment = new TeamsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Const.BUNDLE_TEAM_KEY, id);
        fragment.setArguments(bundle);
        getViewState().navigateTo(fragment);
    }

    public void onLeagueClick(String id) {
        LeagueTableFragment fragment = new LeagueTableFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Const.BUNDLE_LEAGUE_KEY, id);
        fragment.setArguments(bundle);
        getViewState().navigateTo(fragment);
    }

}