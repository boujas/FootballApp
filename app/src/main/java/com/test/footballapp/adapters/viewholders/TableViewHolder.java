package com.test.footballapp.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.test.footballapp.R;
import com.test.footballapp.models.Standing;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TableViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_position)
    TextView position;
    @BindView(R.id.txt_name)
    TextView name;
    @BindView(R.id.txt_games)
    TextView games;
    @BindView(R.id.txt_goals)
    TextView goals;
    @BindView(R.id.txt_wins)
    TextView wins;
    @BindView(R.id.txt_loses)
    TextView loses;

    public TableViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bind(Standing standing) {
        position.setText(standing.getPosition());
        name.setText(standing.getTeamName());
        games.setText(standing.getPlayedGames());
        goals.setText(standing.getGoals());
        wins.setText(standing.getWins());
        loses.setText(standing.getLosses());
    }

}
