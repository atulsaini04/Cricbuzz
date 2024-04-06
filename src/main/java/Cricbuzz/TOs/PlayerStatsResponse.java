package com.example.myfirstproject.firstproject.TOs;
public class PlayerStatsResponse {
    private String playerId;
    private String name;
    private int matchesPlayed;
    private int runs;
    private double average;
    private double strikeRate;

    public PlayerStatsResponse() {
    }

    public PlayerStatsResponse(String playerId, String name, int matchesPlayed, int runs, double average, double strikeRate) {
        this.playerId = playerId;
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.runs = runs;
        this.average = average;
        this.strikeRate = strikeRate;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }
// Constructors, getters, and setters
}
