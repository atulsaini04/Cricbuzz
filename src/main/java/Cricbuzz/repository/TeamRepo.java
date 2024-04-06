package Cricbuzz.repository;

import Cricbuzz.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TeamRepo extends JpaRepository<Team, Long> {
    // You can define custom query methods here if needed
}