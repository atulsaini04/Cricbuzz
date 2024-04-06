package Cricbuzz.TOs;

import Cricbuzz.entity.Match;

import java.util.List;
import java.util.stream.Collectors;

public class MatchDetailsResponse {
    private String matchId;
    private String team1;
    private String team2;
    private String date;
    private String venue;
    private String status;
    private List<SquadResponse> squads;

    public MatchDetailsResponse(Match match) {
        this.matchId = String.valueOf(match.getId());
        this.team1 = match.getTeam1();
        this.team2 = match.getTeam2();
        this.date = match.getDate();
        this.venue = match.getVenue();
        this.status = "upcoming"; // Assuming all matches are upcoming
        this.squads = match.getSquads().stream().map(SquadResponse::new).collect(Collectors.toList());
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SquadResponse> getSquads() {
        return squads;
    }

    public void setSquads(List<SquadResponse> squads) {
        this.squads = squads;
    }
// Getter and setter
}

