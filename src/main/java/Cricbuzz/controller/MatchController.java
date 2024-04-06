package Cricbuzz.controller;

import Cricbuzz.TOs.*;
import Cricbuzz.entity.AuthToken;
import Cricbuzz.entity.Match;
import Cricbuzz.repository.AuthTokenRepository;
import Cricbuzz.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MatchController {

    @Autowired
    private MatchService matchService;
    @Autowired
    private final AuthTokenRepository authTokenRepository;

    public MatchController(AuthTokenRepository authTokenRepository) {
        this.authTokenRepository = authTokenRepository;
    }

    @PostMapping("/matches")
    public ResponseEntity<?> createMatch(@RequestHeader("Authorization") String authorizationHeader, @RequestBody MatchRequest matchRequest) {
        // Validate the access token
        if (!isLoggedIn(authorizationHeader)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not authorized or not logged in");
        }

        // Create the match
        Match createdMatch = matchService.createMatch(matchRequest);

        // Prepare response
        MatchResponse response = new MatchResponse("Match created successfully", createdMatch.getMatchId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/matches")
    public ResponseEntity<?> getAllMatches() {
        List<Match> matches = matchService.getAllMatches();
        return ResponseEntity.status(HttpStatus.OK).body(new MatchesResponse(matches));
    }
    @GetMapping("/matches/{match_id}")
    public ResponseEntity<?> getMatchById(@PathVariable("match_id") Long matchId) {
        Match match = matchService.getMatchById(matchId);
        if (match == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Match not found", HttpStatus.NOT_FOUND.value()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new MatchDetailsResponse(match));
    }
    public boolean isLoggedIn(String authToken) {
        AuthToken token = authTokenRepository.findByToken(authToken);
        if (token != null && token.getExpirationTime().isAfter(LocalDateTime.now())) {
            // Token is valid and not expired
            return true;
        }
        return false;
    }

}

