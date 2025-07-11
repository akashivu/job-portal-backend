package com.example.demo.Service;

import com.example.demo.Dto.JobRequestDto;
import com.example.demo.Entity.Job;
import com.example.demo.Repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepo;
    public Job addJob(JobRequestDto jobDto,String recruiterEmail){
      Job job= Job.builder()
              .title(jobDto.getTitle())
              .description(jobDto.getDescription())
              .location(jobDto.getLocation())
              .company(jobDto.getCompany())
              .employmentType(jobDto.getEmploymentType())
              .postedBy(recruiterEmail)
              .build();
      return jobRepo.save(job);

    }
  public List<Job> getAllJobs(){
        return jobRepo.findAll();
  }
    public List<Job> getJobsByRecruiter(String recruiterEmail) {
        return jobRepo.findByPostedBy(recruiterEmail);
    }
}
