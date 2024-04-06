package Cricbuzz.service;

import Cricbuzz.TOs.MatchRequest;
import Cricbuzz.entity.Match;

import java.util.List;

public interface MatchService {
    Match createMatch(MatchRequest matchRequest);
    List<Match> getAllMatches();
    Match getMatchById(Long matchId);


}