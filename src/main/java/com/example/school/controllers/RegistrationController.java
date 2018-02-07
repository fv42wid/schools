package com.example.school.controllers;

import com.example.school.commands.RegistrationForm;
import com.example.school.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration/register";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        userRepository.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
