package com.example.myfirstproject.firstproject.service;

import com.example.myfirstproject.firstproject.TOs.PlayerRequest;
import com.example.myfirstproject.firstproject.entity.Player;

public interface SquadService {
    Player addPlayerToSquad(Long teamId, PlayerRequest playerRequest);
}
