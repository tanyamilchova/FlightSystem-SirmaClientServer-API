package com.sirma.tanyamilchova.demo.controller;

import com.sirma.tanyamilchova.demo.model.LoginResponse;
import com.sirma.tanyamilchova.demo.model.dto.LoginUserDto;
import com.sirma.tanyamilchova.demo.model.dto.RegisterUserDto;
import com.sirma.tanyamilchova.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterUserDto user) {
        authService.register(user);
        return ResponseEntity.ok("User registered!");
    }

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto user) {
        LoginResponse response = authService.login(user);
        return ResponseEntity.ok(response);
    }
}
