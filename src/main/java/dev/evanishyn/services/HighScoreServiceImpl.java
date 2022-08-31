package dev.evanishyn.services;

import dev.evanishyn.entities.HighScore;
import dev.evanishyn.repos.HighScoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Service
public class HighScoreServiceImpl implements HighScoreService {

    @Autowired
    HighScoreRepo highScoreRepo;


    @Override
    public HighScore createNewScore(HighScore highScore) {
        //initials saved as uppercase
        if(highScore.getInitials() != null){
            String updInitials = highScore.getInitials().toUpperCase();

        //initials only 3 characters long
            if(updInitials.length()>=3 ){
                updInitials = highScore.getInitials().substring(0,3).toUpperCase();
                System.out.println(updInitials);
                highScore.setInitials(updInitials);

        //no negative scores
                if(highScore.getHighScore() > 0 && highScore.getInitials().length() == 3){
                return this.highScoreRepo.save(highScore);
                }
                throw new RuntimeException("Must have a score above 0 and 3 letters of initials");
            }
            throw new RuntimeException("You need at least 3 characters for your initials");
        }
        throw new RuntimeException("Initials required. Preferably 3 characters and uppercase");
    }


    @Override
    public HighScore getScoreById(int id) {
        Optional<HighScore> possibleHighscore = this.highScoreRepo.findById(id);

        if(possibleHighscore.isPresent()){
            return possibleHighscore.get();
        }else{
            throw new RuntimeException("Id not found");
        }
    }

//    @Override
//    public List<HighScore> getAllScores() {
//        List<HighScore> scores = this.highScoreRepo.findAll(Sort.by(Sort.Direction.DESC, "highScore"));
//        return scores;
//    }
    //scores shown in descending order

    @Override
    public List<HighScore> getAllScores() {
        List<HighScore> scores = this.highScoreRepo.findAll(Sort.by(Sort.Direction.DESC, "highScore"));
        return scores;
    }

    @Override
    public List<HighScore> getScoresByInitials(String initials) {
        return null;
    }


    @Override
    public HighScore updateScore(HighScore highScore){

        return this.updateScore(highScore);
    }



}





