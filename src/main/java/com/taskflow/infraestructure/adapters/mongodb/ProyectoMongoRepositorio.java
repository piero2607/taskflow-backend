package com.taskflow.infraestructure.adapters.mongodb;

import com.taskflow.domain.model.Proyecto;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ProyectoMongoRepositorio extends MongoRepository<Proyecto, String> {

    List<Proyecto> findByPropietarioIdOrIdsMiembros(String propietarioId, String miembroId);
}