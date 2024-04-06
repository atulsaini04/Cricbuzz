package com.example.myfirstproject.firstproject.service;

import com.example.myfirstproject.firstproject.TOs.PlayerStatsResponse;

public interface PlayerService {
    PlayerStatsResponse getPlayerStats(Long playerId);
}
