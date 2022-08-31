package dev.evanishyn.app;

import dev.evanishyn.entities.HighScore;
import dev.evanishyn.repos.HighScoreRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
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
        HighScore hs2 = new HighScore(0, "AAA", 200);
        HighScore savedHs2 = this.highScoreRepo.save(hs2);

        HighScore hs3 = new HighScore(0, "AAA", 300);
        HighScore savedHs3 = this.highScoreRepo.save(hs3);


        List<HighScore> scores = this.highScoreRepo.findAll();
        System.out.println(scores);
        Assertions.assertEquals(2, scores.size());
    }

//    @Test
//    public void get_score_by_id(){
//        HighScore hs = this.highScoreRepo.findById(1).get();    //needs isPresent() to check
//        System.out.println(hs);
//    }


}
