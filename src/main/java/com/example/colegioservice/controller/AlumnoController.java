package com.example.colegioservice.controller;

import com.example.colegioservice.entity.Alumno;
import com.example.colegioservice.service.AlumnoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("alumnos")
@AllArgsConstructor
public class AlumnoController {

    private final AlumnoService alumnoService;

    @GetMapping("listarAlumnos")
    public List<Alumno> listarAlumnos() {

        List<Alumno> alumnos = new ArrayList<>();

        alumnos = alumnoService.buscarAlumnos();
        return alumnos;
    }

    @PostMapping("guardarAlumno")
    public Alumno guardarAlumno(@RequestBody Alumno alumno) {
        Alumno alumnoGuardadoOk = alumnoService.guardarAlumno(alumno);
        return alumnoGuardadoOk;
    }

    @DeleteMapping("eliminarAlumno/{id}")
    public String eliminarAlumno(@PathVariable Integer id) {
        alumnoService.eliminarAlumno(id);
        return "El alumno fue eliminado con exito ...";
    }

}
