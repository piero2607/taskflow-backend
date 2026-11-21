package com.taskflow.infraestructure.adapters.mongodb;

import com.taskflow.application.ports.UserRepositoryPort;
import com.taskflow.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MongoUserRepositoryAdapter implements UserRepositoryPort {

    private final UserMongoRepository userMongoRepository;

    @Override
    public User save(User user) {
        return userMongoRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userMongoRepository.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return findByEmail(email).isPresent();
    }
}