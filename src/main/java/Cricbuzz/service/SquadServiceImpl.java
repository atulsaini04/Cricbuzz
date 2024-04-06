package Cricbuzz.service;
import Cricbuzz.TOs.PlayerRequest;
import Cricbuzz.entity.Player;
import Cricbuzz.entity.Team;
import Cricbuzz.repository.PlayerRepo;
import Cricbuzz.repository.TeamRepo;
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
