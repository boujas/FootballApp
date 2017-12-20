package com.test.footballapp.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.footballapp.R;
import com.test.footballapp.adapters.TeamsRVAdapter;
import com.test.footballapp.models.Team;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TeamViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_team_name)
    TextView fullName;
    @BindView(R.id.txt_team_short)
    TextView shortName;
    @BindView(R.id.img_team_logo)
    ImageView teamLogo;

    private TeamsRVAdapter.OnItemClickListener mListener;
    private Team mTeam;

    public TeamViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bind(Team team, TeamsRVAdapter.OnItemClickListener listener) {
        mTeam = team;
        mListener = listener;
        fullName.setText(team.getName());
        String sname = team.getShortName() != null && !team.getShortName().isEmpty() ? team.getShortName() : "";
        if (team.getCrestUrl() != null && !team.getCrestUrl().isEmpty())
            Picasso.with(teamLogo.getContext())
                    .load(team.getCrestUrl())
                    .placeholder(R.drawable.logo)
                    .into(teamLogo);
        else
            Picasso.with(teamLogo.getContext()).load(R.color.colorAccent).into(teamLogo);
        shortName.setText(sname);
    }

    @OnClick(R.id.team_layout)
    void onClick() {
        String id;
        if (mTeam.getLinks() != null)
            id = mTeam.getLinks().getPlayers().getHref()
                    .replace("http://api.football-data.org/v1/teams/", "")
                    .replace("/players", "");
        else
            id = null;
        mListener.onItemClick(id);
    }
}
