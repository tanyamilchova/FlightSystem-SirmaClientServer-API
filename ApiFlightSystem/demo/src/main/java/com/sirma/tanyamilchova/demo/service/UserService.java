package com.sirma.tanyamilchova.demo.service;


import com.sirma.tanyamilchova.demo.model.UserInfo;
import com.sirma.tanyamilchova.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserInfo register(UserInfo userInfo) {
        return userRepository.save(userInfo);
    }

}
