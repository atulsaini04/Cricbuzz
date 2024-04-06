package com.example.myfirstproject.firstproject.TOs;

import com.example.myfirstproject.firstproject.entity.Player;

public class PlayerResponse {
    private String playerId;
    private String name;

    public PlayerResponse(String playerId, String name) {
        this.playerId = playerId;
        this.name = name;
    }

    public PlayerResponse(Player player) {
        this.playerId = String.valueOf(player.getId());
        this.name = player.getName();
    }

    public PlayerResponse() {
    }

    public PlayerResponse(PlayerResponse playerResponse) {
    }
    // Getter and setter
}

