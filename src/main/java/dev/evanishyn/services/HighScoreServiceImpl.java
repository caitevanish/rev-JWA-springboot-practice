package dev.evanishyn.services;

import dev.evanishyn.entities.HighScore;
import dev.evanishyn.repos.HighScoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HighScoreServiceImpl implements HighScoreService {

    @Autowired
    HighScoreRepo highScoreRepo;


    @Override
    public HighScore createNewScore(HighScore highScore) {
        HighScore hs = this.highScoreRepo.save(highScore);
        return hs;
    }
    //no negative scores
    //initials only 3 characters long
    //initials saved as uppercase


    @Override
    public HighScore getScoreById(int id) {
        Optional<HighScore> possibleHighscore = this.highScoreRepo.findById(id);
        return null;
    }


    @Override
    public List<HighScore> getAllScores() {
        return null;
    }
    //scores shown in descending order

    @Override
    public List<HighScore> getScoresByInitials(String initials) {
        return null;
    }
    //use query param to sort by initials
    //example:
    //OrderBy
    //
    //findByAgeOrderByLastnameDesc
    //
    //… where x.age = ?1 order by x.lastname desc
}
