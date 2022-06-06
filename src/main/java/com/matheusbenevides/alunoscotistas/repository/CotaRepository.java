package com.matheusbenevides.alunoscotistas.repository;

import com.matheusbenevides.alunoscotistas.entity.Cota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CotaRepository extends JpaRepository<Cota, Long> {

    Cota findByNome(String nome);
}
