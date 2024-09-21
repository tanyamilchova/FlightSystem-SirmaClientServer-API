package com.example.demo.service;


import com.example.demo.model.UserInfo;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserInfo register(UserInfo userInfo) {
        return userRepository.save(userInfo);
    }

}
