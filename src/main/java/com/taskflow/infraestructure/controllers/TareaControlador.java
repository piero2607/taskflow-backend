package com.taskflow.infraestructure.controllers;

import com.taskflow.application.usecases.CrearTareaCasoUso;
import com.taskflow.domain.model.Tarea;
import com.taskflow.infraestructure.controllers.dto.CrearTareaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tareas")
@RequiredArgsConstructor
public class TareaControlador {

    private final CrearTareaCasoUso crearTareaCasoUso;

    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody CrearTareaRequest peticion, Authentication autenticacion) {
        String correoUsuario = autenticacion.getName();

        Tarea nuevaTarea = crearTareaCasoUso.ejecutar(
                correoUsuario,
                peticion.getProyectoId(),
                peticion.getTitulo(),
                peticion.getDescripcion(),
                peticion.getPrioridad(),
                peticion.getFechaLimite()
        );

        return ResponseEntity.ok(nuevaTarea);
    }
}