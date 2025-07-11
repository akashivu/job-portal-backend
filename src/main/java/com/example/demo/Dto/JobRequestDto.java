package com.example.demo.Dto;

import lombok.Data;

@Data
public class JobRequestDto {
   private String title;
   private String description;
   private String location;
   private String company;
   private String employmentType;

}
