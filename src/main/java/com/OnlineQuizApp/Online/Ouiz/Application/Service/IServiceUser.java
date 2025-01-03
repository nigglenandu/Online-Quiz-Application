package com.OnlineQuizApp.Online.Ouiz.Application.Service;

import com.OnlineQuizApp.Online.Ouiz.Application.Entity.User;

import java.util.List;
import java.util.Optional;

public interface IServiceUser {
    List<User> getAllUser();
    Optional<User> getUserById(Long id);
    Optional<User> getUserByUserName(String username);
    void addUser(User user);
    boolean deleteById(Long id);
}
