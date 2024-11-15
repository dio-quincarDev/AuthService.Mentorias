package com.example.authService.Security.Mentorias.controllers.impl;

import com.example.authService.Security.Mentorias.common.dtos.TokenResponse;
import com.example.authService.Security.Mentorias.common.dtos.UserRequest;
import com.example.authService.Security.Mentorias.controllers.AuthApi;
import com.example.authService.Security.Mentorias.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<TokenResponse> createUser(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.ok(authService.createUser(userRequest));
    }
}
