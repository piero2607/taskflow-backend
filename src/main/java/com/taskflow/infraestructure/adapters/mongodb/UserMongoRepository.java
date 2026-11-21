package com.taskflow.infraestructure.adapters.mongodb;

import com.taskflow.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserMongoRepository extends MongoRepository <User, String>{

    Optional<User> findByEmail(String email);
}
