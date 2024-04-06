package com.example.myfirstproject.firstproject.TOs;

import com.example.myfirstproject.firstproject.entity.Match;
import java.util.List;
import java.util.stream.Collectors;

public class MatchesResponse {
    private List<MatchResponse> matches;

    public MatchesResponse(List<Match> matches) {
        this.matches = matches.stream().map(MatchResponse::new).collect(Collectors.toList());
    }
}
