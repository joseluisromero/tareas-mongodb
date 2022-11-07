package com.crud.mongodb.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
@Builder
public class Person {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private Date created;
}
