package com.example.colegioservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Data;

@Table
@Entity
@Data
public class Profesor {
    @Id
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer dni;
    private Integer edad;
    private String materia;
    private Character sexo;



}
