package com.example.school.converters;

import com.example.school.commands.JobCommand;
import com.example.school.models.Job;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class JobCommandToJob implements Converter<JobCommand, Job> {

    @Synchronized
    @Nullable
    @Override
    public Job convert(JobCommand source) {
        if(source == null) {
            return null;
        }

        final Job job = new Job();
        job.setId(source.getId());
        job.setCompany(source.getCompany());
        job.setPosition(source.getPosition());
        job.setStartDate(source.getStartDate());
        job.setEndDate(source.getEndDate());

        return job;
    }
}
