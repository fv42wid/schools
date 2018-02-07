package com.example.school.controllers;

import com.example.school.commands.RegistrationForm;
import com.example.school.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
    public String registerForm(Model model) {
        model.addAttribute("registration", new RegistrationForm());
        return "registration/register";
    }

    @PostMapping
    public String processRegistration(@Valid @ModelAttribute("registration") RegistrationForm form, Errors errors) {
        if(errors.hasErrors()) {
            return "registration/register";
        }

        userRepository.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
