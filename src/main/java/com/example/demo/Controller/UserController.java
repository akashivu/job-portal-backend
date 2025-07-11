package com.example.demo.Controller;

import com.example.demo.Dto.UserRequestDto;
import com.example.demo.Service.UserService;
import com.example.demo.Entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService service;

    @PostMapping("/registeruser")
    public ResponseEntity<?> register(@RequestBody UserRequestDto dto) {
        String token = service.registerUser(dto);
        return ResponseEntity.ok(token);
    }
}
