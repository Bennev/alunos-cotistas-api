package com.matheusbenevides.alunoscotistas.repository;

import com.matheusbenevides.alunoscotistas.entity.Campus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampusRepository extends JpaRepository<Campus, Long> {

    Campus findBySlug(String slug);

}
