package com.clinica.infrastructure.persistence.repository;

import com.clinica.infrastructure.persistence.entity.SeguimientoClinicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataSeguimientoRepository extends JpaRepository<SeguimientoClinicoEntity, Long> {
}
