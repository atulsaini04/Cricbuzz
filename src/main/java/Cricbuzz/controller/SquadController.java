package com.example.myfirstproject.firstproject.controller;
import com.example.myfirstproject.firstproject.TOs.AddPlayerResponse;
import com.example.myfirstproject.firstproject.TOs.ErrorResponse;
import com.example.myfirstproject.firstproject.TOs.PlayerRequest;
import com.example.myfirstproject.firstproject.entity.Player;
import com.example.myfirstproject.firstproject.service.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teams")
public class SquadController {

    @Autowired
    private SquadService squadService;

    @PostMapping("/{team_id}/squad")
    public ResponseEntity<?> addPlayerToSquad(@PathVariable("team_id") Long teamId, @RequestBody PlayerRequest playerRequest) {
        Player player = squadService.addPlayerToSquad(teamId, playerRequest);
        if (player == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Team not found", HttpStatus.NOT_FOUND.value()));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new AddPlayerResponse("Player added to squad successfully", player.getId()));
    }
}


