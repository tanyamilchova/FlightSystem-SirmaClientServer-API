package com.sirma.tanyamilchova.client.contriller;


import com.sirma.tanyamilchova.client.model.User;
import com.sirma.tanyamilchova.client.service.UserService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {
    private  static final Logger logger=  LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService service;

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("user", new User());
        return "register";

    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model){
        try {
            service.register(user);
            return "redirect:/login";
        } catch (Exception e){
            model.addAttribute("user", new User());
            model.addAttribute("error", "Error occurred during registration");
            return "register";
        }
    }

    @GetMapping("/login")
    public String loginPage(@ModelAttribute User user,
                            @RequestParam(value = "logout", required = false) String logout,
                            @RequestParam(value = "error", required = false) String error,
                            Model model){

        if (logout != null) {
            model.addAttribute("message", "You have been successfully logged out.");
            logger.info("User logged out successfully.");
        } else {
            model.addAttribute("message", "Please log in.");
            logger.info("get login page");
            if (user.getUsername() == null || user.getUsername().isEmpty()) {
                model.addAttribute("error", "Please provide a username.");
            }
            if (user.getPassword() == null || user.getPassword().isEmpty()) {
                model.addAttribute("error", "Please provide a password.");
            }
            if (error != null) {
                model.addAttribute("error", error);
            }
        }
        return "login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute User user,
                        Model model,
                        RedirectAttributes redirectAttributes) {
        logger.info("Login attempt for user: {}", user.getUsername());
        try {
            service.login(user);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("user", user);
            model.addAttribute("error", "Error occurred during login");
            logger.error("Login failed for user: {}", user.getUsername(), e);
            return "login";
        }
    }


    @GetMapping("/user")
    public String testUserJWT(Model model){
        logger.info("get user page");
        service.tesrUserJWT();
        return "user";
    }

    @GetMapping("/admin")
    public String testAdminJWT(Model model){
        logger.info("get admin page");
        service.tesrAdmivJWT();
        return "admin";
    }
}

