package com.example.myfirstproject.firstproject.service;
import com.example.myfirstproject.firstproject.TOs.PlayerStatsResponse;
import com.example.myfirstproject.firstproject.entity.Player;
import com.example.myfirstproject.firstproject.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepo playerRepository;

    @Override
    public PlayerStatsResponse getPlayerStats(Long playerId) {
        Player player = playerRepository.findById(playerId).orElse(null);
        if (player != null) {
            // Calculate player stats here (mock data used for demonstration)
            int matchesPlayed = 200;
            int runs = 12000;
            double average = 59.8;
            double strikeRate = 92.5;

            // Create and return PlayerStatsResponse
            return new PlayerStatsResponse(playerId.toString(), player.getName(), matchesPlayed, runs, average, strikeRate);
        }
        return null;
    }
}
