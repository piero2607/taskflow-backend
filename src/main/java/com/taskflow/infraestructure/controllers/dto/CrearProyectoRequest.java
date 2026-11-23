package com.taskflow.infraestructure.controllers.dto;

import lombok.Data;

@Data
public class CrearProyectoRequest {
    private String nombre;
    private String descripcion;
}