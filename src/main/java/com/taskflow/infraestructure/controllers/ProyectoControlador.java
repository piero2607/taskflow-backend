package com.taskflow.infraestructure.controllers;

import com.taskflow.application.usecases.CrearProyectoCasoUso;
import com.taskflow.application.usecases.ListarProyectosCasoUso;
import com.taskflow.domain.model.Proyecto;
import com.taskflow.infraestructure.controllers.dto.CrearProyectoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
@RequiredArgsConstructor
public class ProyectoControlador {

    private final CrearProyectoCasoUso crearProyectoCasoUso;
    private final ListarProyectosCasoUso listarProyectosCasoUso;


    @PostMapping
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody CrearProyectoRequest peticion, Authentication autenticacion) {
        String correoUsuario = autenticacion.getName();

        Proyecto nuevoProyecto = crearProyectoCasoUso.ejecutar(
                correoUsuario,
                peticion.getNombre(),
                peticion.getDescripcion()
        );

        return ResponseEntity.ok(nuevoProyecto);
    }

    @GetMapping
    public ResponseEntity<List<Proyecto>> listarProyectos(Authentication autenticacion) {
        String correoUsuario = autenticacion.getName();
        List<Proyecto> proyectos = listarProyectosCasoUso.ejecutar(correoUsuario);
        return ResponseEntity.ok(proyectos);
    }
}