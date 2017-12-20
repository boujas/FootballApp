package com.test.footballapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.footballapp.R;
import com.test.footballapp.adapters.viewholders.TeamViewHolder;
import com.test.footballapp.models.Team;

import java.util.List;

public class TeamsRVAdapter extends RecyclerView.Adapter<TeamViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(String id);
    }

    private List<Team> mTeamList;
    private TeamsRVAdapter.OnItemClickListener mClickListener;

    public TeamsRVAdapter(List<Team> teamList, TeamsRVAdapter.OnItemClickListener listener) {
        mTeamList = teamList;
        mClickListener = listener;
    }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final TeamViewHolder holder, final int position) {
        holder.bind(mTeamList.get(position), mClickListener);
    }

    @Override
    public int getItemCount() {
        return mTeamList.size();
    }

}