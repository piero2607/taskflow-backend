package com.taskflow.infraestructure.adapters.mongodb;

import com.taskflow.application.ports.TareaRepositorioPuerto;
import com.taskflow.domain.model.Tarea;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TareaMongoAdaptador implements TareaRepositorioPuerto {

    private final TareaMongoRepositorio repositorioMongo;

    @Override
    public Tarea guardar(Tarea tarea) {
        return repositorioMongo.save(tarea);
    }

    @Override
    public List<Tarea> buscarPorProyectoId(String proyectoId) {
        return repositorioMongo.findByProyectoId(proyectoId);
    }

    @Override
    public Optional<Tarea> buscarPorId(String idTarea) {
        return repositorioMongo.findById(idTarea);
    }
}