package com.clinica.infrastructure.persistence.repository;

import com.clinica.infrastructure.persistence.entity.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMedicoRepository extends JpaRepository<MedicoEntity, Long> {
}
