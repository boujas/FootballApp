package com.test.footballapp.models.response;

import com.test.footballapp.models.Standing;

import java.util.List;

public class TableResponse {

    private String leagueCaption;
    private String matchday;
    private List<Standing> standing;

    public TableResponse(String leagueCaption, String matchday, List<Standing> standing) {
        this.leagueCaption = leagueCaption;
        this.matchday = matchday;
        this.standing = standing;
    }

    public String getLeagueCaption() {
        return leagueCaption;
    }

    public void setLeagueCaption(String leagueCaption) {
        this.leagueCaption = leagueCaption;
    }

    public String getMatchday() {
        return matchday;
    }

    public void setMatchday(String matchday) {
        this.matchday = matchday;
    }

    public List<Standing> getStanding() {
        return standing;
    }

    public void setStanding(List<Standing> standing) {
        this.standing = standing;
    }

    @Override
    public String toString() {
        return "TableResponse{" +
                "leagueCaption='" + leagueCaption + '\'' +
                ", matchday='" + matchday + '\'' +
                ", standing=" + standing +
                '}';
    }

}