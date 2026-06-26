package com.example.colegioservice.service;

import com.example.colegioservice.entity.Alumno;

import java.util.List;

public interface AlumnoService {

    List<Alumno> buscarAlumnos();
    Alumno guardarAlumno(Alumno alumno);
    void eliminarAlumno(Integer id);

    //declarr crear. actualizar y borrar
}
