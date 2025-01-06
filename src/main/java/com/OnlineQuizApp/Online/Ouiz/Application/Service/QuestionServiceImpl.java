package com.OnlineQuizApp.Online.Ouiz.Application.Service;

import com.OnlineQuizApp.Online.Ouiz.Application.Entity.Question;
import com.OnlineQuizApp.Online.Ouiz.Application.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements IServiceQuestion{
    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public boolean updateQuestionById(Question question, Long id) {
        Optional<Question> optional = questionRepository.findById(id);
        if(optional.isPresent()){
            Question questionToUpdate = optional.get();
            questionToUpdate.setQuestionText(question.getQuestionText());
            questionToUpdate.setOptions(question.getOptions());
            questionToUpdate.setCorrectAnswer(question.getCorrectAnswer());
            questionRepository.save(questionToUpdate);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if(questionRepository.existsById(id)){
            questionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
