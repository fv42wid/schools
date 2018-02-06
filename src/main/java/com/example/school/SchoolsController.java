package com.example.school;

import com.example.school.commands.SchoolCommand;
import com.example.school.services.SchoolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/schools/new")
    public String newSchool(Model model) {
        model.addAttribute("school", new SchoolCommand());
        return "school/form";
    }

    @PostMapping({"/schools", "/schools/"})
    public String saveOrUpdate(@ModelAttribute SchoolCommand command) {
        SchoolCommand savedCommand = schoolService.saveSchoolCommand(command);
        return "redirect:/schools";
    }

}
