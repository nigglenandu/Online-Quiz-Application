package com.OnlineQuizApp.Online.Ouiz.Application.Repository;

import com.OnlineQuizApp.Online.Ouiz.Application.Entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> getScoreByUserId(Long userId);
    List<Score> getScoreByQuizId(Long quizId);
}
