package com.mateusbenevides.alunoscotistas.repository;

import com.mateusbenevides.alunoscotistas.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
