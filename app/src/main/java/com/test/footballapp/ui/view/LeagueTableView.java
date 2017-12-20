package com.test.footballapp.ui.view;

import com.arellomobile.mvp.MvpView;
import com.test.footballapp.models.Standing;

import java.util.List;

public interface LeagueTableView extends MvpView{

    void updateData(List<Standing> standings);

    void goBack();

    void onError(String message);

}