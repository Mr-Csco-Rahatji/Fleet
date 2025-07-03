package com.example.Fleet.controller;


import com.example.Fleet.model.Manager;
import com.example.Fleet.repository.ManagerRepository;
import com.example.Fleet.config.JwtUtil;
import com.example.Fleet.dto.AuthRequest;
import com.example.Fleet.dto.AuthResponse;
import com.example.Fleet.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final ManagerRepository managerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager,
                          ManagerRepository managerRepository,
                          PasswordEncoder passwordEncoder,
                          JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.managerRepository = managerRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        if (managerRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already in use");
        }
        Manager manager = new Manager();
        manager.setName(request.getName());
        manager.setSurname(request.getSurname());
        manager.setEmail(request.getEmail());
        manager.setPassword(passwordEncoder.encode(request.getPassword()));
        managerRepository.save(manager);
        return ResponseEntity.ok("Manager registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.generateToken((UserDetails) authentication.getPrincipal());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
