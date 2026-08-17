package com.example.colegioservice.service;

import com.example.colegioservice.entity.Alumno;

import java.util.List;

public interface AlumnoService {

    List<Alumno> buscarAlumnos();
    List<Alumno> buscarAlumnosFiltro(Integer edad,String sexo,String materia);
    Alumno guardarAlumno(Alumno alumno);
    void eliminarAlumno(Integer id);
    Alumno actualizarAlumno(Integer id, Alumno alumno);
    //declarr crear. actualizar y borrar
}
