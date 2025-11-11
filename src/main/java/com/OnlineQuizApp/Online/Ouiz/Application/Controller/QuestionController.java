package com.OnlineQuizApp.Online.Ouiz.Application.Controller;

import com.OnlineQuizApp.Online.Ouiz.Application.Entity.Question;
import com.OnlineQuizApp.Online.Ouiz.Application.Service.IServiceQuestion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionsssssss")
public class QuestionController {

    private final IServiceQuestion serviceQuestion;

    public QuestionController(IServiceQuestion serviceQuestion) {
        this.serviceQuestion = serviceQuestion;
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = serviceQuestion.getAllQuestions();
        return questions.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        return serviceQuestion.getQuestionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createQuestion(@RequestBody Question question) {
        serviceQuestion.addQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        serviceQuestion.updateQuestionById(question, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        boolean isDeleted = serviceQuestion.deleteById(id);
        return isDeleted ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.notFound().build();
    }
}