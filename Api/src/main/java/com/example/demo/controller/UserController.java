package com.example.demo.controller;


import com.example.demo.model.UserInfo;
import com.example.demo.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping("/getAll")
    public List<UserInfo> register(@RequestBody UserInfo userInfo){
        return new ArrayList<>();
    }

    @GetMapping("profile")
    public void getProfile(){
    }
}

