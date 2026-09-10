package com.example.colegioservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table
@Entity
@Data
public class Profesor {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El nombre solo puede contener letras y espacios")
    @NotEmpty(message = "El nombre de usuario es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El apellido solo puede contener letras y espacios")
    private String apellido;

    @NotNull(message = "El DNI es obligatorio")
    @Min(value = 10000000, message = "El DNI debe tener al menos 8 dígitos")
    @Max(value = 99999999, message = "El DNI no puede exceder los 8 dígitos")
    private String dni;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 18, message = "El profesor debe ser mayor de edad (mínimo 18 años)")
    @Max(value = 100, message = "La edad no puede ser mayor a 100 años")
    private Integer edad;

    @NotBlank(message = "La materia no puede estar vacía")
    @Size(min = 2, max = 50, message = "La materia debe tener entre 2 y 50 caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ 0-9]+$", message = "La materia solo puede contener letras, números y espacios")
    private String materia;

    @NotNull(message = "El sexo no puede estar vacío")
    private String sexo;



}
