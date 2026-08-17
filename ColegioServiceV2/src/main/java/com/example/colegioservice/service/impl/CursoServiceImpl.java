package com.example.colegioservice.service.impl;

import com.example.colegioservice.entity.Curso;
import com.example.colegioservice.repository.CursoRepository;
import com.example.colegioservice.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso actualizarCurso(Integer id, Curso curso) {
        Curso cursoExistente = cursoRepository.findById(id).orElse(null);
        if (cursoExistente != null) {
            cursoExistente.setNombre(curso.getNombre());
            cursoExistente.setDescripcion(curso.getDescripcion());
            cursoExistente.setHoraEntrada(curso.getHoraEntrada());
            cursoExistente.setMaestro(curso.getMaestro());
            cursoExistente.setAula(curso.getAula());
            cursoExistente.setPrecio(curso.getPrecio());

            return cursoRepository.save(cursoExistente);
        }
        return null;
    }

    @Override
    public void eliminarCurso(Integer id) {
        cursoRepository.deleteById(id);
    }
}
