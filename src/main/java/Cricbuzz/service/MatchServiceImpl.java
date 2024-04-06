package Cricbuzz.service;

import Cricbuzz.TOs.MatchRequest;
import Cricbuzz.entity.Match;
import Cricbuzz.repository.MatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepo matchRepository;

    @Override
    public Match createMatch(MatchRequest matchRequest) {
        // Convert MatchRequest to Match entity
        Match match = new Match();
        match.setTeam1(matchRequest.getTeam1());
        match.setTeam2(matchRequest.getTeam2());
        match.setDate(matchRequest.getDate());
        match.setVenue(matchRequest.getVenue());

        // Save match to database
        return matchRepository.save(match);
    }
    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
    @Override
    public Match getMatchById(Long matchId) {
        return matchRepository.findById(matchId).orElse(null);
    }
}
