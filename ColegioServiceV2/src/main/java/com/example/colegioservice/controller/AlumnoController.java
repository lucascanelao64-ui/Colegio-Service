package com.example.colegioservice.controller;

import com.example.colegioservice.entity.Alumno;
import com.example.colegioservice.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    // 1. Obtener todos los alumnos
    @GetMapping("/listarAlumnos")
    public ResponseEntity<List<Alumno>> listarAlumnos() {
        return ResponseEntity.ok(alumnoService.buscarAlumnos());
    }

    // Obtener un alumno por su ID
    @GetMapping("/buscar/{id}")
    public Alumno buscarAlumnoPorId(@PathVariable Integer id) {
        return alumnoService.buscarAlumnoPorId(id);
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
    @PostMapping("/guardar")
    public ResponseEntity<Alumno> guardarAlumno(@RequestBody Alumno alumno) {
        Alumno nuevoAlumno = alumnoService.guardarAlumno(alumno);
        return new ResponseEntity<>(nuevoAlumno, HttpStatus.CREATED);
    }

    // 4. Actualizar un alumno existente
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(
            @PathVariable Integer id,
            @RequestBody Alumno alumno) {

        alumno.setId(id);
        Alumno alumnoActualizado = alumnoService.actualizarAlumno(id,alumno);
        return ResponseEntity.ok(alumnoActualizado);
    }

    // 5. Eliminar un alumno por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Integer id) {
        alumnoService.eliminarAlumno(id);
        return ResponseEntity.noContent().build();
    }
}