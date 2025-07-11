package com.example.demo.Repository;

import com.example.demo.Entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application,Long> {
    List<Application> findBySeekerEmail(String email);
    List<Application>  findByJobId(Long jobId);
}
