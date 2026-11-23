package com.taskflow.application.usecases;

import com.taskflow.application.ports.ProyectoRepositorioPuerto;
import com.taskflow.application.ports.UserRepositoryPort;
import com.taskflow.domain.model.Proyecto;
import com.taskflow.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrearProyectoCasoUso {

    private final ProyectoRepositorioPuerto repositorioProyecto;
    private final UserRepositoryPort repositorioUsuario;

    public Proyecto ejecutar(String correoUsuario, String nombre, String descripcion) {
        User usuario = repositorioUsuario.findByEmail(correoUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Proyecto nuevoProyecto = Proyecto.builder()
                .nombre(nombre)
                .descripcion(descripcion)
                .propietarioId(usuario.getId())
                .build();

        return repositorioProyecto.guardar(nuevoProyecto);
    }
}