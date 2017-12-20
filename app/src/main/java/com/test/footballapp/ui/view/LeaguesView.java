package com.test.footballapp.ui.view;

import android.app.Fragment;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.test.footballapp.models.League;

import java.util.List;

public interface LeaguesView extends MvpView {

    void updateData(List<League> leagues);

    @StateStrategyType(SkipStrategy.class)
    void navigateTo(Fragment fragment);

    void onError(String message);

}