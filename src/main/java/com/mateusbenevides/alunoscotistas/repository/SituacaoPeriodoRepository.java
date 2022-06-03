package com.mateusbenevides.alunoscotistas.repository;

import com.mateusbenevides.alunoscotistas.entity.SituacaoPeriodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituacaoPeriodoRepository extends JpaRepository<SituacaoPeriodo, Long> {

    SituacaoPeriodo findByNome(String nome);
}
