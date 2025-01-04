package com.OnlineQuizApp.Online.Ouiz.Application.Controller;

import com.OnlineQuizApp.Online.Ouiz.Application.Entity.Question;
import com.OnlineQuizApp.Online.Ouiz.Application.Service.IServiceQuestion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    public IServiceQuestion serviceQuestion;

    public QuestionController(IServiceQuestion serviceQuestion) {
        this.serviceQuestion = serviceQuestion;
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions(){
        return new ResponseEntity<>(serviceQuestion.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("id")
    public ResponseEntity<Question> getQuestionById(Long id){
        return serviceQuestion.getQuestionById(id)
                .map(question -> new ResponseEntity<>(question, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("create")
    public ResponseEntity<Void> createQuestion(Question question){
        serviceQuestion.addQuestion(question);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
