package com.OnlineQuizApp.Online.Ouiz.Application.Service;

import com.OnlineQuizApp.Online.Ouiz.Application.Entity.Score;

import java.util.List;
import java.util.Optional;

public interface IServiceScore {
    List<Score> getAllScore();
    Optional<Score> getScoreById(Long id);
    void addScore(Score score);
    List<Score> getScoreByUserId(Long Userid);
    List<Score> getScoresByQuizId(Long quizId);
    boolean deleteById(Long id);
}
