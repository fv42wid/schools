package com.example.school.converters;

import com.example.school.commands.SchoolCommand;
import com.example.school.models.School;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SchoolCommandToSchool implements Converter<SchoolCommand, School> {

    @Synchronized
    @Nullable
    @Override
    public School convert(SchoolCommand source) {
        if(source == null) {
            return null;
        }

        final School school = new School();
        school.setId(source.getId());
        school.setName(source.getName());
        school.setStartDate(source.getStartDate());
        school.setEndDate(source.getEndDate());
        school.setDegree(source.getDegree());

        return school;
    }
}
