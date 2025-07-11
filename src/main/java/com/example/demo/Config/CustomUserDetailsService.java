package com.example.demo.Config;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository repo;


    public CustomUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException{
       User user= repo.findByEmail(Email).orElseThrow(()-> new UsernameNotFoundException("user not fpound"));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }
}
