package com.test.footballapp.ui.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.test.footballapp.R;
import com.test.footballapp.adapters.TeamsRVAdapter;
import com.test.footballapp.models.Team;
import com.test.footballapp.ui.base.BaseFragment;
import com.test.footballapp.ui.presenter.TeamsPresenter;
import com.test.footballapp.ui.view.TeamsView;
import com.test.footballapp.utils.Const;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamsFragment extends BaseFragment implements TeamsView{

    @InjectPresenter
    TeamsPresenter mPresenter;

    @BindView(R.id.recycler)
    RecyclerView mRecycler;

    private TeamsRVAdapter mAdapter;
    private List<Team> mTeamList;

    public TeamsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teams, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        String teamId = bundle.getString(Const.BUNDLE_TEAM_KEY);
        mTeamList = new ArrayList<>();
        setRecycler();
        mPresenter.init(teamId);
        return view;
    }

    private void setRecycler(){
        mAdapter = new TeamsRVAdapter(mTeamList, id -> {

        });
        LinearLayoutManager linearManager = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(linearManager);
        mRecycler.setAdapter(mAdapter);
    }

    public void updateData(List<Team> teams){
        mTeamList.clear();
        mTeamList.addAll(teams);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String message) {
        super.onError(message);
    }

    @Override
    public void goBack(){
        getFragmentManager().popBackStack();
    }

}
