package com.taskflow.application.usecases;

import com.taskflow.application.ports.UserRepositoryPort;
import com.taskflow.domain.model.Role;
import com.taskflow.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RegisterUserUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoder passwordEncoder;

    public User execute(String name, String email, String rawPassword) {
        if (userRepositoryPort.existsByEmail(email)) {
            throw new IllegalArgumentException("El correo electrónico ya está registrado");
        }

        String encodedPassword = passwordEncoder.encode(rawPassword);

        User newUser = User.builder()
                .name(name)
                .email(email)
                .password(encodedPassword)
                .roles(Set.of(Role.ROLE_USER))
                .build();

        return userRepositoryPort.save(newUser);
    }
}