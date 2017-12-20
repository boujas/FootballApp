package com.test.footballapp.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.test.footballapp.R;
import com.test.footballapp.adapters.TableRVAdapter;
import com.test.footballapp.models.Standing;
import com.test.footballapp.ui.base.BaseFragment;
import com.test.footballapp.ui.presenter.LeagueTablePresenter;
import com.test.footballapp.ui.view.LeagueTableView;
import com.test.footballapp.utils.Const;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeagueTableFragment extends BaseFragment implements LeagueTableView {

    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;

    @InjectPresenter
    LeagueTablePresenter mPresenter;

    private TableRVAdapter mAdapter;
    private List<Standing> mStandingList;

    public LeagueTableFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_league_table, container, false);
        ButterKnife.bind(this, view);
        mStandingList = new ArrayList<>();
        Bundle bundle = getArguments();
        String leagueId = bundle.getString(Const.BUNDLE_LEAGUE_KEY);
        initRecyclerView();
        mPresenter.init(leagueId);
        return view;
    }

    private void initRecyclerView(){
        mAdapter = new TableRVAdapter(mStandingList);
        LinearLayoutManager linearManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void updateData(List<Standing> standings) {
        mStandingList.clear();
        mStandingList.addAll(standings);
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
