package com.matheusbenevides.alunoscotistas.repository;

import com.matheusbenevides.alunoscotistas.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findByNome(String nome);
}
