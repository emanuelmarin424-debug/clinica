package com.clinica.domain.model;

import java.time.LocalDate;

public class SeguimientoClinico {

    private Long id;
    private Long idPaciente;
    private Long idMedico;
    private LocalDate fecha;
    private String observaciones;
    private String recomendaciones;

    public SeguimientoClinico(Long id, Long idPaciente, Long idMedico, LocalDate fecha,
                              String observaciones, String recomendaciones) {
        if (observaciones == null || observaciones.isBlank()) {
            throw new IllegalArgumentException("Las observaciones son obligatorias");
        }
        this.id = id;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.fecha = fecha;
        this.observaciones = observaciones;
        this.recomendaciones = recomendaciones;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }
}
