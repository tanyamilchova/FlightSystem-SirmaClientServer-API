package com.sirma.tanyamilchova.client.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LoginResponse {
    private String token;
    private Long expiresIn;
    private String username;
    private List<String> roles;
    private String error;
}
