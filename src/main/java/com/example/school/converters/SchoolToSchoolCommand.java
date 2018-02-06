package com.example.school.converters;

import com.example.school.commands.SchoolCommand;
import com.example.school.models.School;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class SchoolToSchoolCommand implements Converter<School, SchoolCommand> {

    @Synchronized
    @Nullable
    @Override
    public SchoolCommand convert(School source){
        if(source == null) {
            return null;
        }

        final SchoolCommand command = new SchoolCommand();
        command.setId(source.getId());
        command.setName(source.getName());
        command.setStartDate(source.getStartDate());
        command.setEndDate(source.getEndDate());
        command.setDegree(source.getDegree());

        return command;
    }

}
