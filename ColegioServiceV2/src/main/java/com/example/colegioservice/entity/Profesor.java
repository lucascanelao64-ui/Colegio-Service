package com.example.colegioservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table
@Entity
@Data
public class Profesor {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer dni;
    private Integer edad;
    private String materia;
    private Character sexo;



}
