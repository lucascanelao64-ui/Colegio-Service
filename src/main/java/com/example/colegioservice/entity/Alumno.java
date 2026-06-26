package com.example.colegioservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String sexo;
    private String carrera;

}
