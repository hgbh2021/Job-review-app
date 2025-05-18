package com.example.rest_api.job;
import com.example.rest_api.job.implementation.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class jobController {
   public JobService jobService;

    public jobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
   public ResponseEntity<List<Job>> findAll(){
       return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
   }

   @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
       jobService.createJob(job);
       return new ResponseEntity<>("Job is Created.", HttpStatus.OK);
   }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){

        Job job= jobService.getJobById(id);
        if( job!=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}")
    public String deleteJob(@PathVariable Long id){
        Job job = jobService.deleteJobById(id);
        if( job!= null){
            return "Deleted";
        }
        return "not deleted";

    }
}
