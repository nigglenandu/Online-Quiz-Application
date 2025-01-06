package com.OnlineQuizApp.Online.Ouiz.Application.Service;

import com.OnlineQuizApp.Online.Ouiz.Application.Entity.Score;
import com.OnlineQuizApp.Online.Ouiz.Application.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreRepositoryImpl implements IServiceScore {
    private final ScoreRepository scoreRepository;
    @Autowired public ScoreRepositoryImpl(@Lazy ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public List<Score> getAllScore() {
        return scoreRepository.findAll();
    }

    @Override
    public Optional<Score> getScoreById(Long id) {
        return scoreRepository.findById(id);
    }

    @Override
    public void addScore(Score score) {
        scoreRepository.save(score);
    }

    @Override
    public List<Score> getScoresByUserId(Long userId) {
        return scoreRepository.getScoreByUserId(userId);
    }

    @Override
    public List<Score> getScoresByQuizId(Long quizId) {
        return scoreRepository.getScoreByQuizId(quizId);
    }

    @Override
    public boolean deleteById(Long id) {
        if(scoreRepository.existsById(id)){
            scoreRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
