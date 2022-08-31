package dev.evanishyn.controllers;

import dev.evanishyn.entities.HighScore;
import dev.evanishyn.repos.HighScoreRepo;
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
    public List<HighScore> allScores(){
            return highScoreService.getAllScores();
    }

    @GetMapping("/highscores/{id}")
    @ResponseBody
    public HighScore getScorebyId(@PathVariable String id){
        int scoreId = Integer.parseInt(id);
        return highScoreService.getScoreById(scoreId);
    }

    @PutMapping("/highscores")
    @ResponseBody
    public HighScore updateScoreById(@PathVariable HighScore highScore){
        return this.highScoreService.updateScore(highScore);
    }

//    @DeleteMapping("/highscores/{id}")
//    @ResponseBody
//    public HighScore deleteScore



}
