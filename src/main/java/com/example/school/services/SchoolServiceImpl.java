package com.example.school.services;

import com.example.school.commands.SchoolCommand;
import com.example.school.converters.SchoolCommandToSchool;
import com.example.school.converters.SchoolToSchoolCommand;
import com.example.school.models.School;
import com.example.school.models.User;
import com.example.school.repositories.SchoolRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolCommandToSchool schoolCommandToSchool;
    private final SchoolToSchoolCommand schoolToSchoolCommand;

    public SchoolServiceImpl(SchoolRepository schoolRepository,
                             SchoolCommandToSchool schoolCommandToSchool,
                             SchoolToSchoolCommand schoolToSchoolCommand) {
        this.schoolRepository = schoolRepository;
        this.schoolCommandToSchool = schoolCommandToSchool;
        this.schoolToSchoolCommand = schoolToSchoolCommand;
    }

    @Override
    public Set<School> getSchools() {
        Set<School> schoolSet = new HashSet<>();
        schoolRepository.findAll().iterator().forEachRemaining(schoolSet::add);
        return schoolSet;
    }

    @Override
    public School findById(Long id) {
        Optional<School> schoolOptional = schoolRepository.findById(id);

        return schoolOptional.get();
    }

    @Override
    public SchoolCommand saveSchoolCommand(SchoolCommand command, User user) {
        School detachedSchool = schoolCommandToSchool.convert(command);
        detachedSchool.setUser(user);
        detachedSchool.setCreatedAt(new Date());

        School savedSchool = schoolRepository.save(detachedSchool);
        return schoolToSchoolCommand.convert(savedSchool);
    }

    @Override
    public SchoolCommand findCommandById(Long id) {
        return schoolToSchoolCommand.convert(findById(id));
    }

    @Override
    public void deleteById(Long id) {
        schoolRepository.deleteById(id);
    }
}
