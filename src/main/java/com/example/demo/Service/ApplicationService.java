package com.example.demo.Service;

import com.example.demo.Entity.Application;
import com.example.demo.Entity.Job;
import com.example.demo.Repository.ApplicationRepository;
import com.example.demo.Repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository appRepo;
    private final JobRepository jobRepo;

    public Application applyToJob(Long jobId,String seekerEmail){
        Job job= jobRepo.findById(jobId).orElseThrow(()->new RuntimeException("job not found"));

        boolean alreadyApplied =appRepo.findByJobId(jobId).stream().anyMatch(app->app.getSeekerEmail().equals(seekerEmail));

        if(alreadyApplied){
            throw new RuntimeException("you already applied for job");

        }
        Application app= Application.builder()
                .jobId(job.getId())
                .jobTitle(job.getTitle())
                .seekerEmail(seekerEmail).build();
        return appRepo.save(app);
    }
  public List<Application> getAppliedJobs(String seekerEmail){
        return appRepo.findBySeekerEmail(seekerEmail);
  }
    public List<Application> getApplicantsForJob(Long jobId) {
        return appRepo.findByJobId(jobId);
    }
}
