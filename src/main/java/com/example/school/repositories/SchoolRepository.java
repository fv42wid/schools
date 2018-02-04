package com.example.school.repositories;

import com.example.school.models.School;
import org.springframework.data.repository.CrudRepository;

public interface SchoolRepository extends CrudRepository<School, Long> {
}
