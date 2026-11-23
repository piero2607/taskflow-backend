package com.taskflow.infraestructure.controllers.dto;

import com.taskflow.domain.model.PrioridadTarea;
import lombok.Data;
import java.time.LocalDate;

@Data
public class CrearTareaRequest {
    private String proyectoId;
    private String titulo;
    private String descripcion;
    private PrioridadTarea prioridad;
    private LocalDate fechaLimite;
}