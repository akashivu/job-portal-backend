package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private String title;
    private String location;
    private String company;
    private String employmentType;
    private String postedBy;
}
