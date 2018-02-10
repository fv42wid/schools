package com.example.school.services;

import com.example.school.commands.JobCommand;
import com.example.school.converters.JobCommandToJob;
import com.example.school.converters.JobToJobCommand;
import com.example.school.models.Job;
import com.example.school.models.User;
import com.example.school.repositories.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final JobCommandToJob jobCommandToJob;
    private final JobToJobCommand jobToJobCommand;

    public JobServiceImpl(JobRepository jobRepository, JobCommandToJob jobCommandToJob, JobToJobCommand jobToJobCommand) {
        this.jobRepository = jobRepository;
        this.jobCommandToJob = jobCommandToJob;
        this.jobToJobCommand = jobToJobCommand;
    }

    @Override
    public Set<Job> getJobs() {
        Set<Job> jobSet = new HashSet<>();
        jobRepository.findAll().iterator().forEachRemaining(jobSet::add);
        return jobSet;
    }

    @Override
    public Job findById(Long id) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        return jobOptional.get();
    }

    @Override
    public JobCommand saveJobCommand(JobCommand command, User user) {
        Job detachedJob = jobCommandToJob.convert(command);
        detachedJob.setUser(user);
        detachedJob.setCreatedAt(new Date());

        Job savedJob = jobRepository.save(detachedJob);
        return jobToJobCommand.convert(savedJob);
    }

    @Override JobCommand findCommandById(Long id) {
        return jobToJobCommand.convert(findById(id));
    }

    @Override
    public void deleteById(Long id) {
        jobRepository.deleteById(id);
    }
}
