package com.example.rest_api.job.implementation;

import com.example.rest_api.job.Job;
import com.example.rest_api.job.jobService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService implements jobService {
    private final List<Job> jobs= new ArrayList<>();
    private Long nextId=1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for( Job job: jobs){
            if( job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }
    @Override
    public Job deleteJobById(Long id) {
        jobs.removeIf(job -> job.getId().equals(id));
        return null;
    }
}
