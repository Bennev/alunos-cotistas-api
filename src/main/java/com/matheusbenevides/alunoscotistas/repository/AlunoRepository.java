package com.matheusbenevides.alunoscotistas.repository;

import com.matheusbenevides.alunoscotistas.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
