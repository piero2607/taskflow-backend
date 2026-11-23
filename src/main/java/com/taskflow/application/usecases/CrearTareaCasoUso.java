package com.taskflow.application.usecases;

import com.taskflow.application.ports.ProyectoRepositorioPuerto;
import com.taskflow.application.ports.TareaRepositorioPuerto;
import com.taskflow.application.ports.UserRepositoryPort;
import com.taskflow.domain.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CrearTareaCasoUso {

    private final TareaRepositorioPuerto repositorioTarea;
    private final ProyectoRepositorioPuerto repositorioProyecto;
    private final UserRepositoryPort repositorioUsuario;

    public Tarea ejecutar(String correoUsuario, String proyectoId, String titulo,
                          String descripcion, PrioridadTarea prioridad, LocalDate fechaLimite) {

        User usuario = repositorioUsuario.findByEmail(correoUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Proyecto proyecto = repositorioProyecto.buscarPorId(proyectoId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        boolean esPropietario = proyecto.getPropietarioId().equals(usuario.getId());
        boolean esMiembro = proyecto.getIdsMiembros().contains(usuario.getId());

        if (!esPropietario && !esMiembro) {
            throw new AccessDeniedException("No tienes permiso para crear tareas en este proyecto");
        }

        Tarea nuevaTarea = Tarea.builder()
                .titulo(titulo)
                .descripcion(descripcion)
                .proyectoId(proyectoId)
                .prioridad(prioridad)
                .fechaLimite(fechaLimite)
                .estado(EstadoTarea.PENDIENTE)
                .build();

        return repositorioTarea.guardar(nuevaTarea);
    }
}