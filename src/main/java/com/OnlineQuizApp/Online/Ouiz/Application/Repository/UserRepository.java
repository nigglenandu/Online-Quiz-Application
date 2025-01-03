package com.OnlineQuizApp.Online.Ouiz.Application.Repository;

import com.OnlineQuizApp.Online.Ouiz.Application.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(String username);
}
