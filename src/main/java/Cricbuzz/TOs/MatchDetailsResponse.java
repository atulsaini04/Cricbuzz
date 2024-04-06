package com.example.myfirstproject.firstproject.TOs;
import com.example.myfirstproject.firstproject.entity.Match;

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

    // Getter and setter
}

