package com.example.school.controllers;

import com.example.school.commands.JobCommand;
import com.example.school.models.User;
import com.example.school.services.JobService;
import com.example.school.services.UserRepositoryUserDetailsService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public String showJob(@PathVariable String id, Model model) {
        model.addAttribute("job", jobService.findById(Long.valueOf(id)));
        return "jobs/show";
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

    @GetMapping("/{id}/update")
    public String updateJob(@PathVariable String id, Model model) {
        model.addAttribute("job", jobService.findCommandById(Long.valueOf(id)));
        return "jobs/form";
    }

    @GetMapping("/{id}/delete")
    public String deleteJob(@PathVariable String id) {
        jobService.deleteById(Long.valueOf(id));
        return "redirect:/jobs";
    }
}
