package com.mateusbenevides.alunoscotistas.repository;

import com.mateusbenevides.alunoscotistas.entity.SituacaoMatricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituacaoMatriculaRepository extends JpaRepository<SituacaoMatricula, Long> {

    SituacaoMatricula findByNome(String nome);
}
