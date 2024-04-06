package Cricbuzz.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Long matchId;
    private String team1;
    private String team2;
    private String date;
    private String venue;

    @OneToMany(mappedBy = "match")
    private List<Squad> squads;


    public Match() {
    }

    public Match(Long matchId, String team1, String team2, String date, String venue, List<Squad> squads) {
        this.matchId = matchId;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.venue = venue;
        this.squads = squads;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public List<Squad> getSquads() {
        return squads;
    }

    public void setSquads(List<Squad> squads) {
        this.squads = squads;
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
}

