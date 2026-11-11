package com.clinica.infrastructure.controller.dto;

public record SeguimientoRequest(Long idPaciente, Long idMedico, String observaciones, String recomendaciones) {
}
