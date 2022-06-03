package com.mateusbenevides.alunoscotistas.repository;

import com.mateusbenevides.alunoscotistas.entity.Cota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CotaRepository extends JpaRepository<Cota, Long> {

    Cota findByNome(String nome);
}
