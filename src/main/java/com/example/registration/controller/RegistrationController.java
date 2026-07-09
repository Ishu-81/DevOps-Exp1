package com.example.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.registration.entity.User;
import com.example.registration.repository.UserRepository;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String showRegistrationForm() {
        return "register";   // Opens templates/register.html
    }

    @PostMapping("/register")
    @ResponseBody
    public String registerUser(User user) {

        userRepository.save(user);

        return "Registration Successful for " + user.getFirstname();
    }
}