package com.test.footballapp.models.links;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;

public class Links extends RealmObject implements Parcelable {

    private Link self;
    private Link teams;
    private Link fixtures;
    private Link leagueTable;
    private Link players;
    private Link competition;

    public Links(){

    }

    private Links(Parcel in) {
        self = in.readParcelable(Link.class.getClassLoader());
        teams = in.readParcelable(Link.class.getClassLoader());
        fixtures = in.readParcelable(Link.class.getClassLoader());
        leagueTable = in.readParcelable(Link.class.getClassLoader());
        players = in.readParcelable(Link.class.getClassLoader());
        competition = in.readParcelable(Link.class.getClassLoader());
    }

    public Links(Link self, Link teams, Link fixtures, Link leagueTable, Link players, Link competition) {
        this.self = self;
        this.teams = teams;
        this.fixtures = fixtures;
        this.leagueTable = leagueTable;
        this.players = players;
        this.competition = competition;
    }

    public Link getSelf() {
        return self;
    }

    public void setSelf(Link self) {
        this.self = self;
    }

    public Link getTeams() {
        return teams;
    }

    public void setTeams(Link teams) {
        this.teams = teams;
    }

    public Link getFixtures() {
        return fixtures;
    }

    public void setFixtures(Link fixtures) {
        this.fixtures = fixtures;
    }

    public Link getLeagueTable() {
        return leagueTable;
    }

    public void setLeagueTable(Link leagueTable) {
        this.leagueTable = leagueTable;
    }

    public Link getPlayers() {
        return players;
    }

    public void setPlayers(Link players) {
        this.players = players;
    }

    public Link getCompetition() {
        return competition;
    }

    public void setCompetition(Link competition) {
        this.competition = competition;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(self, i);
        parcel.writeParcelable(teams, i);
        parcel.writeParcelable(fixtures, i);
        parcel.writeParcelable(leagueTable, i);
        parcel.writeParcelable(players, i);
        parcel.writeParcelable(competition, i);
    }

    public static final Parcelable.Creator<Links> CREATOR
            = new Parcelable.Creator<Links>() {
        public Links createFromParcel(Parcel in) {
            return new Links(in);
        }

        public Links[] newArray(int size) {
            return new Links[size];
        }
    };

}