package com.OnlineQuizApp.Online.Ouiz.Application.Repository;

import com.OnlineQuizApp.Online.Ouiz.Application.Entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
}
