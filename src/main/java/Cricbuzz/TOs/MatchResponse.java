package Cricbuzz.TOs;


import Cricbuzz.entity.Match;

public class MatchResponse {
    private String message;
    private String matchId;

    public MatchResponse() {
    }

    public MatchResponse(String message, String matchId) {
        this.message = message;
        this.matchId = matchId;
    }

    public MatchResponse(Match match) {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }
}

