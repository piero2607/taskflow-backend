package com.taskflow.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "proyectos")
public class Proyecto {

    @Id
    private String idProyecto;

    private String nombre;
    private String descripcion;

    private String propietarioId;

    @Builder.Default
    private List<String> idsMiembros = new ArrayList<>();
}