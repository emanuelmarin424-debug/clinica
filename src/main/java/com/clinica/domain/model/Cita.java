package com.clinica.domain.model;

import java.time.LocalDateTime;

public class Cita {

    private Long id;
    private Long idPaciente;
    private Long idMedico;
    private LocalDateTime fechaHora;
    private String estado;
    private String motivoCancelacion;

    // cita nueva
    public Cita(Long id, Long idPaciente, Long idMedico, LocalDateTime fechaHora) {
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha y hora son obligatorias");
        }
        if (fechaHora.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("No se puede agendar una cita en el pasado");
        }
        this.id = id;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.fechaHora = fechaHora;
        this.estado = "PROGRAMADA";
    }

    // cita leida de la base de datos
    public Cita(Long id, Long idPaciente, Long idMedico, LocalDateTime fechaHora,
                String estado, String motivoCancelacion) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.motivoCancelacion = motivoCancelacion;
    }

    public void cancelar(String motivo) {
        if (!estado.equals("PROGRAMADA")) {
            throw new IllegalStateException("Solo se pueden cancelar citas programadas");
        }
        if (motivo == null || motivo.isBlank()) {
            throw new IllegalArgumentException("Debe escribir el motivo de la cancelacion");
        }
        estado = "CANCELADA";
        motivoCancelacion = motivo;
    }

    public void atender() {
        if (!estado.equals("PROGRAMADA")) {
            throw new IllegalStateException("Solo se pueden atender citas programadas");
        }
        estado = "ATENDIDA";
    }

    public void marcarInasistencia() {
        if (!estado.equals("PROGRAMADA")) {
            throw new IllegalStateException("Solo se puede marcar inasistencia en citas programadas");
        }
        estado = "INASISTENCIA";
    }

    public Long getId() {
        return id;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public String getMotivoCancelacion() {
        return motivoCancelacion;
    }
}
