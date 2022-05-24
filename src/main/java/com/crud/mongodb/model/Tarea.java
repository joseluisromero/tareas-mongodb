package com.crud.mongodb.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
@Builder
public class Tarea {
    @Id
    private String id;
    private String nombre;
    @Builder.Default
    private boolean completada=true;
    private Date created;

}
