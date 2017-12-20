package com.test.footballapp.models;

public class Player {

    private String dateOfBirth;
    private String position;
    private String jerseyNumber;
    private String nationality;
    private String contractUntil;
    private String name;
    private String marketValue;

    public Player(String dateOfBirth, String position, String jerseyNumber, String nationality,
                  String contractUntil, String name, String marketValue) {
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.nationality = nationality;
        this.contractUntil = contractUntil;
        this.name = name;
        this.marketValue = marketValue;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(String jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getContractUntil() {
        return contractUntil;
    }

    public void setContractUntil(String contractUntil) {
        this.contractUntil = contractUntil;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public String toString() {
        return "Player{" +
                "dateOfBirth='" + dateOfBirth + '\'' +
                ", position='" + position + '\'' +
                ", jerseyNumber='" + jerseyNumber + '\'' +
                ", nationality='" + nationality + '\'' +
                ", contractUntil='" + contractUntil + '\'' +
                ", name='" + name + '\'' +
                ", marketValue='" + marketValue + '\'' +
                '}';
    }

}