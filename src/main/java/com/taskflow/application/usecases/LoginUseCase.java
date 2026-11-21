package com.taskflow.application.usecases;

import com.taskflow.application.ports.UserRepositoryPort;
import com.taskflow.domain.model.User;
import com.taskflow.infraestructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String execute(String email, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        User user = userRepositoryPort.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return jwtService.generateToken(user);
    }
}