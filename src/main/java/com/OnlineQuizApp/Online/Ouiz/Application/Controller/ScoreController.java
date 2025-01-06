package com.OnlineQuizApp.Online.Ouiz.Application.Controller;

import com.OnlineQuizApp.Online.Ouiz.Application.Entity.Score;
import com.OnlineQuizApp.Online.Ouiz.Application.Service.IServiceScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("scores")
public class ScoreController {

    @Autowired
    private IServiceScore serviceScore;

    @GetMapping
    public ResponseEntity<List<Score>> getAllScores(){
        return new ResponseEntity<>(serviceScore.getAllScore(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Score> getScoreById(@PathVariable Long id){
        return serviceScore.getScoreById(id)
                .map(score -> new ResponseEntity<>(score,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("create")
    public ResponseEntity<Void> createScore(@RequestBody Score score){
        serviceScore.addScore(score);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("userScore/{userId}")
    public ResponseEntity<List<Score>> getScoresByUserId(@PathVariable Long userId){
        return new ResponseEntity<>(serviceScore.getScoresByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("quizScore/{quizId}")
    public ResponseEntity<List<Score>> getScoresByQuizId(@PathVariable Long quizId){
        return new ResponseEntity<>(serviceScore.getScoresByQuizId(quizId), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteScoreById(@PathVariable Long id){
        boolean isDeleted = serviceScore.deleteById(id);
        if(isDeleted){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
