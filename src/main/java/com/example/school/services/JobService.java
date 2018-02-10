package com.example.school.services;

import com.example.school.commands.JobCommand;
import com.example.school.models.Job;
import com.example.school.models.User;

import java.util.Set;

public interface JobService {

    Set<Job> getJobs();
    Job findById(Long id);
    JobCommand saveJobCommand(JobCommand command, User user);
    JobCommand findCommandById(Long id);
    void deleteById(Long id);
}
