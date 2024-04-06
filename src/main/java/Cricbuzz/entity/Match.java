package Cricbuzz.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String team1;
    private String team2;
    private String date;
    private String venue;

    @OneToMany(mappedBy = "match")
    private List<Squad> squads;


    public Match() {
    }

    public Match(String id, String team1, String team2, String date, String venue) {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.venue = venue;
    }

    public List<Squad> getSquads() {
        return squads;
    }

    public void setSquads(List<Squad> squads) {
        this.squads = squads;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}

