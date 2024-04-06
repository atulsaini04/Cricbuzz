package Cricbuzz.service;

import Cricbuzz.TOs.PlayerStatsResponse;

public interface PlayerService {
    PlayerStatsResponse getPlayerStats(Long playerId);
}
