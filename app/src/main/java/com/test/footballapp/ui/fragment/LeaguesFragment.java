package com.test.footballapp.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.test.footballapp.R;
import com.test.footballapp.adapters.LeaguesRVAdapter;
import com.test.footballapp.models.League;
import com.test.footballapp.ui.base.BaseFragment;
import com.test.footballapp.ui.presenter.LeaguesPresenter;
import com.test.footballapp.ui.view.LeaguesView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaguesFragment extends BaseFragment implements LeaguesView {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    private LeaguesRVAdapter adapter;
    private List<League> leagueList;

    @InjectPresenter
    LeaguesPresenter mPresenter;

    public LeaguesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_league_list, container, false);
        ButterKnife.bind(this, view);
        leagueList = new ArrayList<>();
        setRecyclerView();
        mPresenter.init();
        return view;
    }

    private void setRecyclerView(){
        adapter = new LeaguesRVAdapter(leagueList, new LeaguesRVAdapter.OnItemClickListener() {
            @Override
            public void onItemTeams(String id) {
                mPresenter.onTeamsClick(id);
            }

            @Override
            public void onLeague(String id) {
                mPresenter.onLeagueClick(id);
            }
        });
        LinearLayoutManager linearManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void updateData(List<League> leagues) {
        leagueList.addAll(leagues);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void navigateTo(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, fragment)
                .commit();
    }

    @Override
    public void onError(String message) {
        super.onError(message);
    }

}