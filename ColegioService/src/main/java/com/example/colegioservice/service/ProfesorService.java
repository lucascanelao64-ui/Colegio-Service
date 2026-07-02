package com.example.colegioservice.service;


import com.example.colegioservice.entity.Profesor;

import java.util.List;

public interface ProfesorService {

    List<Profesor> buscarProfesor();
    Profesor guardarProfesor(Profesor profesor);
    Profesor actualizarProfesor(Integer id, Profesor profesor);
    void eliminarProfesor(Integer id);



}
