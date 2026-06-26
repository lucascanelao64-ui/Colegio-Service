package com.example.colegioservice.controller;

import com.example.colegioservice.entity.Profesor;
import com.example.colegioservice.service.ProfesorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("profesores")
@AllArgsConstructor
public class ProfesorController {

    private final ProfesorService profesorService;

    @GetMapping("ListarProfesores")
    public List<Profesor> listarProfesores() {

        List<Profesor> profesor = new ArrayList<>();

        profesor = profesorService.buscarProfesor();
        return profesor;
    }
}
