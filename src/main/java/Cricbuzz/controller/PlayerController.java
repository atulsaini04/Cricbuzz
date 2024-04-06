package Cricbuzz.controller;

import Cricbuzz.TOs.ErrorResponse;
import Cricbuzz.TOs.PlayerStatsResponse;
import Cricbuzz.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/{player_id}/stats")
    public ResponseEntity<?> getPlayerStats(@PathVariable("player_id") Long playerId) {
        PlayerStatsResponse playerStatsResponse = playerService.getPlayerStats(playerId);
        if (playerStatsResponse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Player not found", HttpStatus.NOT_FOUND.value()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(playerStatsResponse);
    }
}


