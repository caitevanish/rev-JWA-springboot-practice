package dev.evanishyn.repos;

import dev.evanishyn.entities.HighScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HighScoreRepo extends JpaRepository<HighScore,Integer>{
// List<HighScore>
}

