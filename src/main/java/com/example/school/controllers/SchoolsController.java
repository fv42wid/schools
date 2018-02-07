package com.example.school.controllers;

import com.example.school.commands.SchoolCommand;
import com.example.school.services.SchoolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
//@RequestMapping("/schools")
public class SchoolsController {

    private final SchoolService schoolService;

    public SchoolsController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping({"/schools", "/schools/"})
    public String showAllSchools(Model model) {
        model.addAttribute("schools", schoolService.getSchools());
        return "school/index";
    }

    @GetMapping("/schools/{id}")
    public String showSchool(@PathVariable String id, Model model) {
        model.addAttribute("school", schoolService.findById(Long.valueOf(id)));
        return "school/show";
    }

    @GetMapping("/schools/new")
    public String newSchool(Model model) {
        model.addAttribute("school", new SchoolCommand());
        return "school/form";
    }

    @PostMapping({"/schools", "/schools/"})
    public String saveOrUpdate(@Valid @ModelAttribute("school") SchoolCommand command, Errors errors) {
        if(errors.hasErrors()) {
            return "school/form";
        }

        SchoolCommand savedCommand = schoolService.saveSchoolCommand(command);
        return "redirect:/schools";
    }

    @GetMapping("/schools/{id}/update")
    public String updateSchool(@PathVariable String id, Model model) {
        model.addAttribute("school", schoolService.findCommandById(Long.valueOf(id)));
        return "school/form";
    }

    @GetMapping("/schools/{id}/delete")
    public String deleteById(@PathVariable String id) {
        schoolService.deleteById(Long.valueOf(id));
        return "redirect:/schools";
    }

}
