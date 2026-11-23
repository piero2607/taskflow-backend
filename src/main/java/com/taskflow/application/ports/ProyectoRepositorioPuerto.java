package com.taskflow.application.ports;

import com.taskflow.domain.model.Proyecto;
import java.util.List;

public interface ProyectoRepositorioPuerto {
    Proyecto guardar(Proyecto proyecto);

    List<Proyecto> buscarPorPropietarioOMiembro(String propietarioId, String miembroId);
}