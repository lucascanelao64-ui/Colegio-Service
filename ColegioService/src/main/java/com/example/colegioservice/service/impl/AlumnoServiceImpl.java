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

    @Override
    public List<Alumno> buscarAlumnosFiltro(Integer edad, String sexo, String materia) {
        if (edad != null){
            List<Alumno> alumnos = alumnoRepository.findAlumnoByEdad(edad);
            return alumnos;
        }else {
            return null;
        }

    }

    @Override
    public Alumno guardarAlumno(Alumno alumno) {
       Alumno alumnoGuardado = alumnoRepository.save(alumno);
        return alumnoGuardado;
    }
    @Override
    public Alumno actualizarAlumno(Integer id, Alumno alumnoActualizado) {
        Alumno alumnoExistente = alumnoRepository.findById(id).orElse(null);
        if (alumnoExistente != null) {
            alumnoExistente.setNombre(alumnoActualizado.getNombre());
            alumnoExistente.setApellido(alumnoActualizado.getApellido());
            alumnoExistente.setEdad(alumnoActualizado.getEdad());
            alumnoExistente.setSexo(alumnoActualizado.getSexo());
            return alumnoRepository.save(alumnoExistente);
        }
        return null;
    }

    @Override
    public void eliminarAlumno(Integer id) {
        alumnoRepository.deleteById(id);
    }

}
