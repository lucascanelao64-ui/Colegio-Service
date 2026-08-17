package com.example.colegioservice.service;

import com.example.colegioservice.entity.Curso;
import java.util.List;

public interface CursoService {
    List<Curso> listarCursos();
    Curso guardarCurso(Curso curso);
    Curso actualizarCurso(Integer id, Curso curso);
    void eliminarCurso(Integer id);
}
