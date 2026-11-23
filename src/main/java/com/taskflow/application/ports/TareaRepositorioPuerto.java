package com.taskflow.application.ports;

import com.taskflow.domain.model.Tarea;
import java.util.List;
import java.util.Optional;

public interface TareaRepositorioPuerto {
    Tarea guardar(Tarea tarea);

    List<Tarea> buscarPorProyectoId(String proyectoId);

    Optional<Tarea> buscarPorId(String idTarea);
}