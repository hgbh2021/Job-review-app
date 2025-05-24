package com.example.rest_api.job.implementation;

import com.example.rest_api.job.Job;
import com.example.rest_api.job.JobRepository;
import com.example.rest_api.job.jobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService implements jobService {
    JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }
    @Override
    public boolean deleteJobById(Long id) {
        try{

         jobRepository.deleteById(id);
         return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        Optional<Job> optionalJob= jobRepository.findById(id);
            if( optionalJob.isPresent()){
                Job job= optionalJob.get();
                job.setTitle(updatedJob.getTitle());
                job.setLocation(updatedJob.getLocation());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                jobRepository.save(job);
                return true;
            }
        return false;
    }
}
