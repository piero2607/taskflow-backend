package com.taskflow.application.usecases;

import com.taskflow.application.ports.ProyectoRepositorioPuerto;
import com.taskflow.application.ports.UserRepositoryPort;
import com.taskflow.domain.model.Proyecto;
import com.taskflow.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarProyectosCasoUso {

    private final ProyectoRepositorioPuerto repositorioProyecto;
    private final UserRepositoryPort repositorioUsuario;

    public List<Proyecto> ejecutar(String correoUsuario) {
        User usuario = repositorioUsuario.findByEmail(correoUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return repositorioProyecto.buscarPorPropietarioOMiembro(usuario.getId(), usuario.getId());
    }
}