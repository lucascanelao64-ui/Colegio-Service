package com.example.colegioservice.service.impl;

import com.example.colegioservice.entity.Alumno;
import com.example.colegioservice.repository.AlumnoRepository;
import com.example.colegioservice.service.AlumnoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.colegioservice.exeption.ResourceNotFoundException;
@Service
@AllArgsConstructor
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> buscarAlumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnos;
    }

    @Override
    public Alumno buscarAlumnoPorId(Integer id) {
        return alumnoRepository.findById(id).orElse(null);
    }
    @Override
    public List<Alumno> buscarAlumnosFiltro(Integer edad, String sexo, String materia) {
        if (edad != null) {
            return alumnoRepository.findAlumnoByEdad(edad);
        } else if (sexo != null) {
            return alumnoRepository.findAlumnoBySexo(sexo);
        } else if (materia != null) {
            return alumnoRepository.findAlumnoByMateria(materia);
        } else {
            return alumnoRepository.findAll();
        }
    }

    @Override
    public Alumno guardarAlumno(Alumno alumno) {
       Alumno alumnoGuardado = alumnoRepository.save(alumno);
        return alumnoGuardado;
    }
    @Override
    public Alumno actualizarAlumno(Integer id, Alumno alumnoActualizado) {
        Alumno alumnoExistente = alumnoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con el ID: " + id));

        alumnoExistente.setNombre(alumnoActualizado.getNombre());
        alumnoExistente.setApellido(alumnoActualizado.getApellido());
        alumnoExistente.setEdad(alumnoActualizado.getEdad());
        alumnoExistente.setSexo(alumnoActualizado.getSexo());
        return alumnoRepository.save(alumnoExistente);
    }

    @Override
    public void eliminarAlumno(Integer id) {
        Alumno alumnoExistente = alumnoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No se puede eliminar. Alumno no encontrado con el ID: " + id));
        alumnoRepository.delete(alumnoExistente);
    }

}
