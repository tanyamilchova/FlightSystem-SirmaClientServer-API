package com.sirma.tanyamilchova.client.contriller;


import com.sirma.tanyamilchova.client.model.User;
import com.sirma.tanyamilchova.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

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
    // TODO add error and logout
    public String loginPage(Model model){
        return "login";
    }

    @PostMapping("/login")
    // TODO add error and logout
    public String login(@ModelAttribute User user, Model model){
        try {
            service.login(user);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("user", user);
            model.addAttribute("error", "Error occurred during login");
            return "login";
        }
    }
}

