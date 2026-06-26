package com.example.colegioservice.service.impl;

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


}
