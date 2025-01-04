package com.OnlineQuizApp.Online.Ouiz.Application.Controller;

import com.OnlineQuizApp.Online.Ouiz.Application.Entity.Quiz;
import com.OnlineQuizApp.Online.Ouiz.Application.Service.IServiceQuiz;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quizzes")
public class QuizController {

    public final IServiceQuiz serviceQuiz;

    public QuizController(IServiceQuiz serviceQuiz) {
        this.serviceQuiz = serviceQuiz;
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes(){
        return new ResponseEntity<>(serviceQuiz.getAllQuiz(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id){
        return serviceQuiz.getQuizById(id)
                .map(quiz -> new ResponseEntity<>(quiz, HttpStatus.OK) )
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("create")
    public ResponseEntity<Void> createQuiz(@RequestBody Quiz quiz){
        serviceQuiz.addQuiz(quiz);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        boolean isDeleted = serviceQuiz.deleteById(id);
        if(isDeleted){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
