package com.OnlineQuizApp.Online.Ouiz.Application.Service;

import com.OnlineQuizApp.Online.Ouiz.Application.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements IServiceQuiz{
    @Autowired
    private QuizRepository quizRepository;

}
