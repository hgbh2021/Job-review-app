package com.example.rest_api.job;

import java.util.List;

public interface jobService {
    List<Job> findAll();
    void createJob(Job job);
}
