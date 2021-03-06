package com.example.school.services;

import com.example.school.commands.SchoolCommand;
import com.example.school.models.School;
import com.example.school.models.User;

import java.util.Set;

public interface SchoolService {

    Set<School> getSchools();
    School findById(Long id);
    SchoolCommand saveSchoolCommand(SchoolCommand command, User user);
    SchoolCommand findCommandById(Long id);
    void deleteById(Long id);
}
