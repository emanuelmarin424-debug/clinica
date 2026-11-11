package com.clinica.infrastructure.persistence.repository;

import com.clinica.infrastructure.persistence.entity.CitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCitaRepository extends JpaRepository<CitaEntity, Long> {
}
