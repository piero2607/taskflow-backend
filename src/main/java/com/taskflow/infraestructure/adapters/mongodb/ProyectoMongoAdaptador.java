package com.taskflow.infraestructure.adapters.mongodb;

import com.taskflow.application.ports.ProyectoRepositorioPuerto;
import com.taskflow.domain.model.Proyecto;
import com.taskflow.infraestructure.adapters.mongodb.ProyectoMongoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProyectoMongoAdaptador implements ProyectoRepositorioPuerto {

    private final ProyectoMongoRepositorio repositorioMongo;

    @Override
    public Proyecto guardar(Proyecto proyecto) {
        return repositorioMongo.save(proyecto);
    }

    @Override
    public List<Proyecto> buscarPorPropietarioOMiembro(String propietarioId, String miembroId) {
        return repositorioMongo.findByPropietarioIdOrIdsMiembros(propietarioId, miembroId);
    }
}