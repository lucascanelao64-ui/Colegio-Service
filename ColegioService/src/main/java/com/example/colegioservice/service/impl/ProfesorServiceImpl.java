package com.example.colegioservice.service.impl;

import com.example.colegioservice.entity.Alumno;
import com.example.colegioservice.entity.Profesor;
import com.example.colegioservice.repository.ProfesorRepository;
import com.example.colegioservice.service.ProfesorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;


    @Override
    public List<Profesor> buscarProfesor(){
        List<Profesor> profesor = profesorRepository.findAll();
        return profesor;
    }

    @Override
    public Profesor guardarProfesor(Profesor profesor) {
        Profesor profesorGuardado = profesorRepository.save(profesor);
        return profesorGuardado;
    }


    @Override
    public Profesor actualizarProfesor(Integer id, Profesor profesorActualizado) {
        Profesor profesorExistente = profesorRepository.findById(id).orElse(null);

        if (profesorExistente != null) {
            profesorExistente.setNombre(profesorActualizado.getNombre());
            profesorExistente.setApellido(profesorActualizado.getApellido());
            profesorExistente.setDni(profesorActualizado.getDni());
            profesorExistente.setEdad(profesorActualizado.getEdad());
            profesorExistente.setMateria(profesorActualizado.getMateria());

            return profesorRepository.save(profesorExistente);
        }
        return null;
    }


    @Override
    public void eliminarProfesor(Integer id) {
        profesorRepository.deleteById(id);
    }


}
