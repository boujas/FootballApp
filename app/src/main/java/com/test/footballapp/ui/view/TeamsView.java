package com.test.footballapp.ui.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.test.footballapp.models.Team;

import java.util.List;

public interface TeamsView extends MvpView {

    void updateData(List<Team> teams);

    @StateStrategyType(SkipStrategy.class)
    void goBack();

    void onError(String message);

}