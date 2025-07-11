package com.example.demo.Controller;

import com.example.demo.Entity.Application;
import com.example.demo.Service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("/{jobId}")
    public ResponseEntity<Application> applyToJob(@PathVariable Long jobId, Authentication auth) {
        String seekerEmail = auth.getName();
        Application app = applicationService.applyToJob(jobId, seekerEmail);
        return ResponseEntity.ok(app);
    }

    @GetMapping("/my")
    public ResponseEntity<List<Application>> myApplications(Authentication auth) {
        String seekerEmail = auth.getName();
        return ResponseEntity.ok(applicationService.getAppliedJobs(seekerEmail));
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<Application>> applicants(@PathVariable Long jobId) {
        return ResponseEntity.ok(applicationService.getApplicantsForJob(jobId));
    }
}
