package com.example.school.controllers;

import com.example.school.commands.JobCommand;
import com.example.school.models.User;
import com.example.school.services.JobService;
import com.example.school.services.UserRepositoryUserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/jobs")
public class JobsController {

    private final JobService jobService;
    private final UserRepositoryUserDetailsService userService;

    public JobsController(JobService jobService, UserRepositoryUserDetailsService userService) {
        this.jobService = jobService;
        this.userService = userService;
    }

    @GetMapping({"", "/"})
    public String showAllJobs(Model model) {
        model.addAttribute("jobs", jobService.getJobs());
        return "jobs/index";
    }

    @GetMapping("/new")
    public String newJob(Model model) {
        model.addAttribute("job", new JobCommand());
        return "jobs/form";
    }

    @PostMapping({"", "/"})
    public String saveOrUpdate(@Valid @ModelAttribute("job") JobCommand command, Errors errors, Principal principal) {
        if(errors.hasErrors()) {
            return "jobs/form";
        }

        User currentUser = userService.loadUserByUsername(principal.getName());
        JobCommand savedCommand = jobService.saveJobCommand(command, currentUser);
        return "redirect:/jobs";
    }
}
