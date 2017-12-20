package com.test.footballapp.models;

import com.test.footballapp.models.links.Links;

public class Standing {

    private String position;
    private String teamName;
    private String crestURI;
    private String playedGames;
    private Links _links;
    private String goals;
    private String losses;
    private String wins;

    public Standing(String position, String teamName, String crestURI, String playedGames,
                    Links _links, String goals, String losses, String wins) {
        this.position = position;
        this.teamName = teamName;
        this.crestURI = crestURI;
        this.playedGames = playedGames;
        this._links = _links;
        this.goals = goals;
        this.losses = losses;
        this.wins = wins;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCrestURI() {
        return crestURI;
    }

    public void setCrestURI(String crestURI) {
        this.crestURI = crestURI;
    }

    public String getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(String playedGames) {
        this.playedGames = playedGames;
    }

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    @Override
    public String toString() {
        return "Standing{" +
                "position='" + position + '\'' +
                ", teamName='" + teamName + '\'' +
                ", crestURI='" + crestURI + '\'' +
                ", playedGames='" + playedGames + '\'' +
                ", _links=" + _links +
                ", goals='" + goals + '\'' +
                ", losses='" + losses + '\'' +
                ", wins='" + wins + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Standing standing = (Standing) o;

        if (position != null ? !position.equals(standing.position) : standing.position != null)
            return false;
        if (teamName != null ? !teamName.equals(standing.teamName) : standing.teamName != null)
            return false;
        if (crestURI != null ? !crestURI.equals(standing.crestURI) : standing.crestURI != null)
            return false;
        if (playedGames != null ? !playedGames.equals(standing.playedGames) : standing.playedGames != null)
            return false;
        if (_links != null ? !_links.equals(standing._links) : standing._links != null)
            return false;
        if (goals != null ? !goals.equals(standing.goals) : standing.goals != null) return false;
        if (losses != null ? !losses.equals(standing.losses) : standing.losses != null)
            return false;
        return wins != null ? wins.equals(standing.wins) : standing.wins == null;
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (teamName != null ? teamName.hashCode() : 0);
        result = 31 * result + (crestURI != null ? crestURI.hashCode() : 0);
        result = 31 * result + (playedGames != null ? playedGames.hashCode() : 0);
        result = 31 * result + (_links != null ? _links.hashCode() : 0);
        result = 31 * result + (goals != null ? goals.hashCode() : 0);
        result = 31 * result + (losses != null ? losses.hashCode() : 0);
        result = 31 * result + (wins != null ? wins.hashCode() : 0);
        return result;
    }
}