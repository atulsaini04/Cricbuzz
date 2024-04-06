package Cricbuzz.TOs;
import Cricbuzz.entity.Match;

public class MatchdetailResponse {
    private Long matchId;
    private String team1;
    private String team2;
    private String date;
    private String venue;

    public MatchdetailResponse() {
    }

    public MatchdetailResponse(Match match) {
        this.matchId = (match.getMatchId());
        this.team1 = match.getTeam1();
        this.team2 = match.getTeam2();
        this.date = match.getDate();
        this.venue = match.getVenue();
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
