package com.OnlineQuizApp.Online.Ouiz.Application.Service;

import com.OnlineQuizApp.Online.Ouiz.Application.Entity.Quiz;

import java.util.List;
import java.util.Optional;

public interface IServiceQuiz {
    List<Quiz> getAllQuiz();
    Optional<Quiz> getQuizById(Long id);
    void addQuiz(Quiz quiz);
    boolean deleteById(Long id);
}
