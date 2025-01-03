package com.OnlineQuizApp.Online.Ouiz.Application.Repository;

import com.OnlineQuizApp.Online.Ouiz.Application.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
