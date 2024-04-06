package Cricbuzz.service;

import Cricbuzz.TOs.PlayerRequest;
import Cricbuzz.entity.Player;
public interface SquadService {
    Player addPlayerToSquad(Long teamId, PlayerRequest playerRequest);
}
