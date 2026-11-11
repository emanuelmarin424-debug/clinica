package com.clinica.infrastructure.persistence.repository;

import com.clinica.infrastructure.persistence.entity.AlertaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAlertaRepository extends JpaRepository<AlertaEntity, Long> {
}
