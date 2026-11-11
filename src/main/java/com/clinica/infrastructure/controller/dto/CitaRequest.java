package com.clinica.infrastructure.controller.dto;

import java.time.LocalDateTime;

public record CitaRequest(Long idPaciente, Long idMedico, LocalDateTime fechaHora) {
}
