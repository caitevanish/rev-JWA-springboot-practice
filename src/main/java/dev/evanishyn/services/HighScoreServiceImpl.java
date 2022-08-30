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
        if(highScore.getInitials() != null){
            String updInitials = highScore.getInitials().toUpperCase();

            if(updInitials.length()>=3 ){
                updInitials = highScore.getInitials().substring(0,3).toUpperCase();
                System.out.println(updInitials);
                highScore.setInitials(updInitials);

                if(highScore.getHighScore() > 0 && highScore.getInitials().length() == 3){
                return this.highScoreRepo.save(highScore);
                }
                throw new RuntimeException("Must have a score above 0 and 3 letters of initials");
            }
            throw new RuntimeException("You need at least 3 characters for your initials");
        }
        throw new RuntimeException("Initials required. (Preferably 3 characters and uppercase)");
    }
    //no negative scores
    //initials only 3 characters long
    //initials saved as uppercase


    @Override
    public HighScore getScoreById(int id) {
        Optional<HighScore> possibleHighscore = this.highScoreRepo.findById(id);

        if(possibleHighscore.isPresent()){
            return possibleHighscore.get();
        }else{
            throw new RuntimeException("Id not found");
        }
    }

    @Override
    public List<HighScore> getAllScores() {
        return this.highScoreRepo.findAll();
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
