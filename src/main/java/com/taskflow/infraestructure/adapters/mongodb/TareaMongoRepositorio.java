package com.taskflow.infraestructure.adapters.mongodb;

import com.taskflow.domain.model.Tarea;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TareaMongoRepositorio extends MongoRepository<Tarea, String> {

    List<Tarea> findByProyectoId(String proyectoId);
}