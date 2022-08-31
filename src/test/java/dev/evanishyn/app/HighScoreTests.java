package dev.evanishyn.app;

import dev.evanishyn.entities.HighScore;
import dev.evanishyn.repos.HighScoreRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class HighScoreTests {

    @Autowired
    HighScoreRepo highScoreRepo;

    @Test
    public void create_high_score(){
        HighScore hs = new HighScore(0, "AAA", 100);
        HighScore savedHs = this.highScoreRepo.save(hs);
        System.out.println(savedHs);
        Assertions.assertNotEquals(0, savedHs.getId());
    }

    @Test
    public void get_all_scores(){
        List<HighScore> scores = this.highScoreRepo.findAll();
        System.out.println(scores);
    }

    @Test
    public void get_score_by_id(){
        HighScore hs = this.highScoreRepo.findById(1).get();    //needs isPresent() to check
        System.out.println(hs);
    }


}
