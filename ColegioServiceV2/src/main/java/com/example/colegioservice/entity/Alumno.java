package com.example.colegioservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table
@Entity
@Data
public class Alumno {

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

    //@Pattern(regexp = "^[0-9]+$", message = "La edad debe contener únicamente números enteros")
    @Min(value = 18, message = "La edad debe ser mayor o igual a 180")//  @Min asegura que el entero no sea negativo o menor al rango que definas (ej: mínimo 18 años).
    @Max(value = 120, message = "La edad no puede ser mayor a 120") //  @Max evita números enteros ridículamente altos de forma lógica.
    private Integer edad;

    @NotNull(message = "El sexo no puede estar vacío")
    private String sexo;

    @NotBlank(message = "La carrera no puede estar vacía")
    @Size(min = 3, max = 50, message = "La carrera debe tener entre 3 y 50 caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "La carrera solo puede contener letras y espacios")
    private String carrera;

    @NotBlank(message = "La materia no puede estar vacía")
    @Size(min = 2, max = 50, message = "La materia debe tener entre 2 y 50 caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ 0-9]+$", message = "La materia solo puede contener letras, números y espacios")
    private String materia;

    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El correo debe tener un formato válido (ejemplo@dominio.com)")
    private String correo;

    private Integer dni; // validar que solo sea numeros, validar que tenga exactamente 8 digitos, y validar por una EXEPCION que dni registrado no se pueda volver a registrar ( nombre de la clase exeption ResourceDocumentNoRepeat)

}
