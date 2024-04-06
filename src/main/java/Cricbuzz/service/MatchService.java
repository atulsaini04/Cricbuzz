package com.example.myfirstproject.firstproject.service;

import com.example.myfirstproject.firstproject.TOs.MatchRequest;
import com.example.myfirstproject.firstproject.entity.Match;

import java.util.List;

public interface MatchService {
    Match createMatch(MatchRequest matchRequest);
    List<Match> getAllMatches();
    Match getMatchById(Long matchId);


}