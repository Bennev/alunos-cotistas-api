package com.matheusbenevides.alunoscotistas.repository;

import com.matheusbenevides.alunoscotistas.entity.SituacaoMatricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituacaoMatriculaRepository extends JpaRepository<SituacaoMatricula, Long> {

    SituacaoMatricula findByNome(String nome);
}
