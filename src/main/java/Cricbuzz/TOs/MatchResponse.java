package Cricbuzz.TOs;


import Cricbuzz.entity.Match;

public class MatchResponse {
    private String message;
    private Long matchId;

    public MatchResponse() {
    }

    public MatchResponse(String message, Long matchId) {
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

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }
}

