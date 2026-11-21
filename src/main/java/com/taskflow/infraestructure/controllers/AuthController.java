package com.taskflow.infraestructure.controllers;

import com.taskflow.application.usecases.LoginUseCase;
import com.taskflow.application.usecases.RegisterUserUseCase;
import com.taskflow.infraestructure.controllers.dto.AuthResponse;
import com.taskflow.infraestructure.controllers.dto.LoginRequest;
import com.taskflow.infraestructure.controllers.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final RegisterUserUseCase registerUserUseCase;
    private final LoginUseCase loginUseCase;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        registerUserUseCase.execute(request.getName(), request.getEmail(), request.getPassword());
        return ResponseEntity.ok("Usuario registrado correctamente");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        String jwtToken = loginUseCase.execute(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(new AuthResponse(jwtToken));
    }

}