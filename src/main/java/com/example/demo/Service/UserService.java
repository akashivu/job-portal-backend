package com.example.demo.Service;

import com.example.demo.Dto.UserRequestDto;
import com.example.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import com.example.demo.Entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Util.JwtUtil;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    public User getUserByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    public String registerUser(UserRequestDto dto) {
        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRole().toUpperCase().replace("ROLE_", ""))
                .build();

        User savedUser = repo.save(user);

        return jwtUtil.generateToken(savedUser);
    }

}

