package com.example.demo.Dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
    private String role;
}
