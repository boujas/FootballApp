package com.test.footballapp.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.test.footballapp.R;
import com.test.footballapp.adapters.LeaguesRVAdapter;
import com.test.footballapp.models.League;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LeagueViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_league_name)
    Button leagueName;
    @BindView(R.id.btn_games)
    TextView gamesNumber;
    @BindView(R.id.btn_teams)
    Button teamsNumber;
    @BindView(R.id.btn_matchdays)
    TextView mutchdaysNumber;
    @BindView(R.id.txt_curr_matchay)
    TextView currentMutchday;
    @BindView(R.id.txt_year)
    TextView year;

    private League mLeague;
    private LeaguesRVAdapter.OnItemClickListener mListener;

    public LeagueViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bind(League league, LeaguesRVAdapter.OnItemClickListener listener) {
        mLeague = league;
        mListener = listener;
        leagueName.setText(league.getLeague());
        gamesNumber.setText(league.getNumberOfGames());
        teamsNumber.setText(league.getNumberOfTeams());
        mutchdaysNumber.setText(league.getNumberOfMatchdays());
        currentMutchday.setText(league.getCurrentMatchday());
        year.setText(league.getYear());
    }

    @OnClick(R.id.btn_teams)
    void onTeamsClick(){
        String id = mLeague.getLinks().getTeams().getHref()
                .replace("http://api.football-data.org/v1/competitions/","")
                .replace("/teams","");
        mListener.onItemTeams(id);
    }

    @OnClick(R.id.txt_league_name)
    void onLeagueClick(){
        mListener.onLeague(mLeague.getId());
    }

}