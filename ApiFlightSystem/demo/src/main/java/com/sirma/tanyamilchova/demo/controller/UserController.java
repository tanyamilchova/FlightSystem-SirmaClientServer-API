package com.sirma.tanyamilchova.demo.controller;


import com.sirma.tanyamilchova.demo.model.UserInfo;
import com.sirma.tanyamilchova.demo.model.dto.RegisterUserDto;
import com.sirma.tanyamilchova.demo.service.UserService;
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
//@PostMapping("/users")
//public UserInfo register(@RequestBody RegisterUserDto registerUserDto){
//    UserInfo userInfo=mapper.map(registerUserDto,UserInfo.class);
//            userService.register(userInfo);
//            return userInfo;
//
//}


    @GetMapping("profile")
    public void getProfile(){
    }

}

