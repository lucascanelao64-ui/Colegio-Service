package com.example.colegioservice.repository;

import com.example.colegioservice.entity.Alumno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

        List<Alumno> findAlumnoByEdad(Integer edad);

    List<Alumno> findAlumnoBySexo(String sexo);

    List<Alumno> findAlumnoByMateria(String materia);


}
