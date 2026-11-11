package com.clinica.infrastructure.persistence.repository;

import com.clinica.infrastructure.persistence.entity.RecepcionistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataRecepcionistaRepository extends JpaRepository<RecepcionistaEntity, Long> {
}
