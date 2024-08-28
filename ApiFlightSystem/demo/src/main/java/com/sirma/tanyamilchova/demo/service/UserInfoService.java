package com.sirma.tanyamilchova.demo.service;

import com.sirma.tanyamilchova.demo.model.UserInfo;
import com.sirma.tanyamilchova.demo.model.UserInfoDetails;
import com.sirma.tanyamilchova.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo =  userRepository.findByUsername(username).orElseThrow();
        return new UserInfoDetails(userInfo);
    }
}
