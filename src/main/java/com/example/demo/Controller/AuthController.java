package com.example.demo.Controller;


import com.example.demo.Dto.UserRequestDto;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import com.example.demo.Util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService service;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;


    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserRequestDto dto) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));


            User user = service.getUserByEmail(dto.getEmail());

            String token = jwtUtil.generateToken(user);

            return ResponseEntity.ok(token);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }


}
