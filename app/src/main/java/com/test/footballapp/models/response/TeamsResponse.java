package com.test.footballapp.models.response;

import com.test.footballapp.models.Team;
import com.test.footballapp.models.links.Links;

import java.util.List;

public class TeamsResponse {

    private Integer count;
    private Links links;
    private List<Team> teams;

    public TeamsResponse(Integer count, Links links, List<Team> teams) {
        this.count = count;
        this.links = links;
        this.teams = teams;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "TeamsResponse{" +
                "count=" + count +
                ", links=" + links +
                ", teams=" + teams +
                '}';
    }

}
