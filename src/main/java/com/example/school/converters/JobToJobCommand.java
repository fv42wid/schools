package com.example.school.converters;

import com.example.school.commands.JobCommand;
import com.example.school.models.Job;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class JobToJobCommand implements Converter<Job, JobCommand> {

    @Synchronized
    @Nullable
    @Override
    public JobCommand convert(Job source) {
        if(source == null) {
            return null;
        }

        final JobCommand command = new JobCommand();
        command.setId(source.getId());
        command.setCompany(source.getCompany());
        command.setPosition(source.getPosition());
        command.setStartDate(source.getStartDate());
        command.setEndDate(source.getEndDate());

        return command;
    }
}
