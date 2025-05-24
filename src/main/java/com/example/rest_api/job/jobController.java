package com.example.rest_api.job;
import com.example.rest_api.job.implementation.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class jobController {
   public JobService jobService;

    public jobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
   public ResponseEntity<List<Job>> findAll(){
       return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
   }

   @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
       jobService.createJob(job);
       return new ResponseEntity<>("Job is Created.", HttpStatus.OK);
   }
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){

        Job job= jobService.getJobById(id);
        if( job!=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleteID = jobService.deleteJobById(id);
        if( deleteID){
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job){
        boolean updateId = jobService.updateJobById(id,job);
        if( updateId){
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
