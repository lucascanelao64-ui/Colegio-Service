package com.example.colegioservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table
@Entity
@Data
public class Alumno {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String sexo;
    private String carrera;

}
