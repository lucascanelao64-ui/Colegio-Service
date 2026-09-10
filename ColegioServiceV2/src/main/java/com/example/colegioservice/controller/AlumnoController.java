package com.example.colegioservice.controller;

import com.example.colegioservice.entity.Alumno;
import com.example.colegioservice.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    // 1. Obtener todos los alumnos
    @GetMapping
    public ResponseEntity<List<Alumno>> listarAlumnos() {
        return ResponseEntity.ok(alumnoService.buscarAlumnos());
    }

    // 2. Filtrar alumnos por parámetros (edad, sexo, materia)
    @GetMapping("/filtro")
    public ResponseEntity<List<Alumno>> listarAlumnosFiltro(
            @RequestParam(name = "edad", required = false) Integer edad,
            @RequestParam(name = "sexo", required = false) String sexo,
            @RequestParam(name = "materia", required = false) String materia) {

        List<Alumno> alumnos = alumnoService.buscarAlumnosFiltro(edad, sexo, materia);
        return ResponseEntity.ok(alumnos);
    }

    // 3. Guardar un nuevo alumno
    @PostMapping
    public ResponseEntity<Alumno> guardarAlumno(@RequestBody Alumno alumno) {
        Alumno nuevoAlumno = alumnoService.guardarAlumno(alumno);
        return new ResponseEntity<>(nuevoAlumno, HttpStatus.CREATED);
    }

    // 4. Actualizar un alumno existente
    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(
            @PathVariable Integer id,
            @RequestBody Alumno alumno) {

        alumno.setId(id);
        Alumno alumnoActualizado = alumnoService.guardarAlumno(alumno);
        return ResponseEntity.ok(alumnoActualizado);
    }

    // 5. Eliminar un alumno por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Integer id) {
        alumnoService.eliminarAlumno(id);
        return ResponseEntity.noContent().build();
    }
}