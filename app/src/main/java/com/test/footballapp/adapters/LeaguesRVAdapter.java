package com.test.footballapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.footballapp.R;
import com.test.footballapp.adapters.viewholders.LeagueViewHolder;
import com.test.footballapp.models.League;

import java.util.List;

public class LeaguesRVAdapter extends RecyclerView.Adapter<LeagueViewHolder> {

    public interface OnItemClickListener {
        void onItemTeams(String id);

        void onLeague(String id);
    }

    private List<League> mLeagueList;
    private OnItemClickListener mClickListener;

    public LeaguesRVAdapter(List<League> leagueList, OnItemClickListener listener) {
        mLeagueList = leagueList;
        mClickListener = listener;
    }

    @Override
    public LeagueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_league, parent, false);
        return new LeagueViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final LeagueViewHolder holder, final int position) {
        holder.bind(mLeagueList.get(position), mClickListener);
    }

    @Override
    public int getItemCount() {
        return mLeagueList.size();
    }

}