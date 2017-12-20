package com.test.footballapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.test.footballapp.models.links.Links;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class League extends RealmObject implements Parcelable{

    @PrimaryKey
    private String id;
    private String numberOfGames;
    private String numberOfTeams;
    private Date lastUpdated;
    private String currentMatchday;
    private Links _links;
    private String year;
    private String caption;
    private String league;
    private String numberOfMatchdays;

    public League(){

    }

    private League(Parcel in) {
        id = in.readString();
        numberOfGames = in.readString();
        numberOfTeams = in.readString();
        lastUpdated = new Date(in.readLong());
        currentMatchday = in.readString();
        _links = in.readParcelable(Links.class.getClassLoader());
        year = in.readString();
        caption = in.readString();
        league = in.readString();
        numberOfMatchdays = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(String numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public String getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(String numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getCurrentMatchday() {
        return currentMatchday;
    }

    public void setCurrentMatchday(String currentMatchday) {
        this.currentMatchday = currentMatchday;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getNumberOfMatchdays() {
        return numberOfMatchdays;
    }

    public void setNumberOfMatchdays(String numberOfMatchdays) {
        this.numberOfMatchdays = numberOfMatchdays;
    }

    public Links getLinks() {
        return _links;
    }

    public void setLinks(Links links) {
        this._links = links;
    }

    @Override
    public String toString() {
        return "League{" +
                "id='" + id + '\'' +
                ", numberOfGames='" + numberOfGames + '\'' +
                ", numberOfTeams='" + numberOfTeams + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", currentMatchday='" + currentMatchday + '\'' +
                ", links=" + _links +
                ", year='" + year + '\'' +
                ", caption='" + caption + '\'' +
                ", league='" + league + '\'' +
                ", numberOfMatchdays='" + numberOfMatchdays + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(numberOfGames);
        parcel.writeString(numberOfTeams);
        parcel.writeLong(lastUpdated.getTime());
        parcel.writeString(currentMatchday);
        parcel.writeParcelable(_links, i);
        parcel.writeString(year);
        parcel.writeString(caption);
        parcel.writeString(league);
        parcel.writeString(numberOfMatchdays);
    }

    public static final Parcelable.Creator<League> CREATOR
            = new Parcelable.Creator<League>() {
        public League createFromParcel(Parcel in) {
            return new League(in);
        }

        public League[] newArray(int size) {
            return new League[size];
        }
    };

}