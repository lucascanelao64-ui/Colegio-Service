package com.example.colegioservice.controller;

import com.example.colegioservice.entity.Alumno;
import com.example.colegioservice.entity.Profesor;
import com.example.colegioservice.service.ProfesorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("GuardarProfesor")
    public Profesor guardar(@RequestBody Profesor profesor) {
        Profesor profesorGuardadoOk = profesorService.guardarProfesor(profesor);
        return profesorGuardadoOk;
    }

    @PutMapping("actualizarProfesor/{id}")
    public String actualizarProfesor(@PathVariable Integer id, @RequestBody Profesor profesor) {
      profesorService.actualizarProfesor(id, profesor);
      return "el profe actualizado";
              
    }

    
    @DeleteMapping("eliminarProfesor/{id}")
    public String eliminarProfesor(@PathVariable Integer id) {
        profesorService.eliminarProfesor(id);
        return "El profesor fue eliminado con exito ...";
        
    }
}
