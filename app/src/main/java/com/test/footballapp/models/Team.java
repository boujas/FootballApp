package com.test.footballapp.models;

import com.test.footballapp.models.links.Links;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Team extends RealmObject{

    @PrimaryKey
    private int id;
    private String squadMarketValue;
    private String crestUrl;
    private String name;
    private Links links;
    private String code;
    private String shortName;

    public Team(){

    }

    public Team(int id, String squadMarketValue, String crestUrl, String name, Links links, String code, String shortName) {
        this.id = id;
        this.squadMarketValue = squadMarketValue;
        this.crestUrl = crestUrl;
        this.name = name;
        this.links = links;
        this.code = code;
        this.shortName = shortName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSquadMarketValue() {
        return squadMarketValue;
    }

    public void setSquadMarketValue(String squadMarketValue) {
        this.squadMarketValue = squadMarketValue;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", squadMarketValue='" + squadMarketValue + '\'' +
                ", crestUrl='" + crestUrl + '\'' +
                ", name='" + name + '\'' +
                ", links=" + links +
                ", code='" + code + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }

}