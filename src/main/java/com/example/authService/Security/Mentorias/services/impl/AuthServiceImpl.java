package com.example.authService.Security.Mentorias.services.impl;

import com.example.authService.Security.Mentorias.common.dtos.TokenResponse;
import com.example.authService.Security.Mentorias.common.dtos.UserRequest;
import com.example.authService.Security.Mentorias.common.entities.UserModel;
import com.example.authService.Security.Mentorias.repositories.UserRepository;
import com.example.authService.Security.Mentorias.services.AuthService;
import com.example.authService.Security.Mentorias.services.JwtService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public TokenResponse createUser(UserRequest userRequest) {
        return Optional.of(userRequest)
                .map(this::mapToEntity)
                .map(userRepository::save)
                .map(userCreated-> jwtService.generateToken(userCreated.getId()))
                .orElseThrow(() -> new RuntimeException("Error creating user"));
    }

    private UserModel mapToEntity (UserRequest userRequest) {
        return UserModel.builder()
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .role("USER")
                .build();
    }

}
