package dev.evanishyn.controllers;

import dev.evanishyn.entities.HighScore;
import dev.evanishyn.services.HighScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HighScoreController {

    @Autowired
    HighScoreService highScoreService;

    @PostMapping("/highscores")
    @ResponseBody
    public HighScore createNewScore(@RequestBody HighScore highScore){
        return this.highScoreService.createNewScore(highScore);
    }


    @GetMapping("/highscores")
    @ResponseBody
    public List<HighScore> allScores(@RequestParam (required = false) String initials){
        if(initials==null){
            return highScoreService.getAllScores();
        }else{
            return highScoreService.getScoresByInitials(initials);
        }
    }

}
