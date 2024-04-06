package com.example.myfirstproject.firstproject.service;
import com.example.myfirstproject.firstproject.TOs.PlayerRequest;
import com.example.myfirstproject.firstproject.entity.Player;
import com.example.myfirstproject.firstproject.entity.Team;
import com.example.myfirstproject.firstproject.repository.PlayerRepo;
import com.example.myfirstproject.firstproject.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SquadServiceImpl implements SquadService {

    @Autowired
    private TeamRepo teamRepository;

    @Autowired
    private PlayerRepo playerRepository;

    @Override
    public Player addPlayerToSquad(Long teamId, PlayerRequest playerRequest) {
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        if (optionalTeam.isPresent()) {
            Team team = optionalTeam.get();
            Player player = new Player();
            player.setName(playerRequest.getName());
            player.setRole(playerRequest.getRole());
            player.setTeam(team);
            playerRepository.save(player);
            return player;
        }
        return null;
    }
}
