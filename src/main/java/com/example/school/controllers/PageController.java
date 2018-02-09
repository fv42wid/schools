package com.example.school.controllers;

import com.example.school.repositories.UserRepository;
import com.example.school.services.UserRepositoryUserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    private final UserRepositoryUserDetailsService userService;

    public PageController(UserRepositoryUserDetailsService userService) {
        this.userService = userService;
    }

    @GetMapping({"", "/"})
    public String home(Model model) {
        model.addAttribute("user", userService.findUserById(1L));
        return "pages/index";
    }
}
