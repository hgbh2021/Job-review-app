package com.example.rest_api.job.implementation;

import com.example.rest_api.job.Job;
import com.example.rest_api.job.jobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService implements jobService {
    public List<Job> jobs= new ArrayList<>();

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);
    }
}
