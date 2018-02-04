package com.example.school.services;

import com.example.school.models.School;

import java.util.Set;

public interface SchoolService {

    Set<School> getSchools();
    School findById(Long id);
}
