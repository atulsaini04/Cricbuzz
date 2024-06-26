package Cricbuzz.repository;

import Cricbuzz.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepo extends JpaRepository<Match, Long> {
    // You can add custom query methods if needed

}
