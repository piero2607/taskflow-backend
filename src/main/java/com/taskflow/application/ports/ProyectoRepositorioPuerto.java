package com.taskflow.application.ports;

import com.taskflow.domain.model.Proyecto;
import java.util.List;
import java.util.Optional;

public interface ProyectoRepositorioPuerto {
    Proyecto guardar(Proyecto proyecto);

    List<Proyecto> buscarPorPropietarioOMiembro(String propietarioId, String miembroId);
    Optional<Proyecto> buscarPorId(String idProyecto);
}