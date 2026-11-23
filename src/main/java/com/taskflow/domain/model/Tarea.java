package com.taskflow.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tareas")
public class Tarea {

    @Id
    private String idTarea;

    private String titulo;
    private String descripcion;

    private String proyectoId;

    private String asignadoA;

    private EstadoTarea estado;
    private PrioridadTarea prioridad;

    private LocalDate fechaLimite;
}