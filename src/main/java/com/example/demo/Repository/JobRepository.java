package com.example.demo.Repository;

import com.example.demo.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {


    List<Job> findByPostedBy(String postedBy);
}
