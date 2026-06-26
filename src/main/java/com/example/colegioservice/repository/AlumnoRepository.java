package com.example.colegioservice.repository;

import com.example.colegioservice.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

}
