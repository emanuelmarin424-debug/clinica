package com.clinica.infrastructure.persistence.repository;

import com.clinica.infrastructure.persistence.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPacienteRepository extends JpaRepository<PacienteEntity, Long> {
}
