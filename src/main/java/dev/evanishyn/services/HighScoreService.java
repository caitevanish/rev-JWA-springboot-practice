package dev.evanishyn.services;

import dev.evanishyn.entities.HighScore;

import java.util.List;

public interface HighScoreService {

    HighScore createNewScore(HighScore highScore);

    HighScore getScoreById(int id);

    List<HighScore> getAllScores();

    List<HighScore> getScoresByInitials(String initials);

    HighScore updateScore(HighScore highScore);
}
