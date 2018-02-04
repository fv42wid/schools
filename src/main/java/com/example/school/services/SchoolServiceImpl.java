package com.example.school.services;

import com.example.school.models.School;
import com.example.school.repositories.SchoolRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
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
}
