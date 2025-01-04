package com.OnlineQuizApp.Online.Ouiz.Application.Service;

import com.OnlineQuizApp.Online.Ouiz.Application.Entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IServiceQuestion {
    List<Question> getAllQuestions();
    Optional<Question> getQuestionById(Long id);
    void addQuestion(Question question);
    boolean updateQuestionById(Long id);
    boolean deleteById(Long id);
}
