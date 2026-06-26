package com.example.colegioservice.controller;

import com.example.colegioservice.entity.Alumno;
import com.example.colegioservice.service.AlumnoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
