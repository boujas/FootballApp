package com.test.footballapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.footballapp.R;
import com.test.footballapp.adapters.viewholders.TableViewHolder;
import com.test.footballapp.models.Standing;

import java.util.List;

public class TableRVAdapter extends RecyclerView.Adapter<TableViewHolder> {

    private List<Standing> mStandingList;

    public TableRVAdapter(List<Standing> leagueList) {
        mStandingList = leagueList;
    }

    @Override
    public TableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_table, parent, false);
        return new TableViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final TableViewHolder holder, final int position) {
        holder.bind(mStandingList.get(position));
    }

    @Override
    public int getItemCount() {
        return mStandingList.size();
    }

}