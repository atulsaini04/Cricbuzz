package Cricbuzz.repository;

import Cricbuzz.entity.Player;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long> {
}