package com.example.colegioservice.service.impl;

import com.example.colegioservice.entity.Alumno;
import com.example.colegioservice.repository.AlumnoRepository;
import com.example.colegioservice.service.AlumnoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> buscarAlumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnos;
    }
}
