package com.example.demo.controller;

import com.example.demo.exeptions.BadRequestException;
import com.example.demo.model.LoginResponse;
import com.example.demo.model.dto.LoginUserDto;
import com.example.demo.model.dto.RegisterUserDto;
import com.example.demo.security.JwtService;
import com.example.demo.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.sirma.tanyamilchova.demo.util.CodesEN.INVALID_CREDENTIAL_EXCEPTION;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private AuthService authService;
    @Autowired
    private JwtService jwtService;


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
        logger.info("hit login endpoint: {}", user);
        try {
            LoginResponse response = authService.login(user);
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            logger.warn("error: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponse().setError(INVALID_CREDENTIAL_EXCEPTION.toString()));
        } catch (BadRequestException e) {
            logger.error("Bad request for login: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse().setError(e.getMessage()));
        } catch (Exception e) {
            logger.error("Unexpected error during login for user: {}", user.getUsername(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new LoginResponse().setError("An unexpected error occurred. Please try again later."));
        }

    }
//    @PostMapping("/logout")
//    public ResponseEntity<Void> logout(HttpServletRequest request){
//        request.getSession().invalidate();
//        //8**
//        logger.info("Invalidated session");
//        //***
//        return ResponseEntity.ok().build();
//    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        return ResponseEntity.ok("Admin role present");
    }

    @GetMapping("/user")
    public ResponseEntity<String> userEndpoint() {
        return ResponseEntity.ok("User role present");
    }


}
