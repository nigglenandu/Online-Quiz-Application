package com.OnlineQuizApp.Online.Ouiz.Application.Service;

import com.OnlineQuizApp.Online.Ouiz.Application.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IServiceUser{
    @Autowired
    private UserRepository userRepository;
}
