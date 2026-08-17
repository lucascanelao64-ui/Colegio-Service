package com.example.colegioservice.controller;

import com.example.colegioservice.entity.Curso;
import com.example.colegioservice.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
@AllArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public List<Curso> listar() {
        return cursoService.listarCursos();
    }

    @PostMapping
    public Curso guardar(@RequestBody Curso curso) {
        return cursoService.guardarCurso(curso);
    }

    @PutMapping("/{id}")
    public Curso actualizar(@PathVariable Integer id, @RequestBody Curso curso) {
        return cursoService.actualizarCurso(id, curso);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        cursoService.eliminarCurso(id);
        return "El curso fue eliminado con éxito...";
    }
}
