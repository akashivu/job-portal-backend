package com.example.demo.Controller;

import com.example.demo.Dto.JobRequestDto;
import com.example.demo.Entity.Job;
import com.example.demo.Service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/api/jobs")
public class JobController {
    private JobService jobService;
     @GetMapping
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }
    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody JobRequestDto dto, Authentication auth) {
        String recruiterEmail = auth.getName();
        Job job = jobService.addJob(dto, recruiterEmail);
        return ResponseEntity.ok(job);
    }

    @GetMapping("/my")
    public ResponseEntity<List<Job>> getMyPostedJobs(Authentication auth) {
        String recruiterEmail = auth.getName();

        return ResponseEntity.ok(jobService.getJobsByRecruiter(recruiterEmail));
    }
}
