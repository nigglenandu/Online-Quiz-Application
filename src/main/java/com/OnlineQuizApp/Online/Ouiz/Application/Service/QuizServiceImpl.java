package com.OnlineQuizApp.Online.Ouiz.Application.Service;

import com.OnlineQuizApp.Online.Ouiz.Application.Entity.Quiz;
import com.OnlineQuizApp.Online.Ouiz.Application.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements IServiceQuiz{
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }

    @Override
    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }

    @Override
    public void addQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }

    @Override
    public boolean deleteById(Long id) {
        if(quizRepository.existsById(id)){
            quizRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }
}
