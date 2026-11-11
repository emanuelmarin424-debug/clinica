package com.clinica.domain.model;

import java.time.LocalDateTime;

public class Alerta {

    private Long id;
    private Long idPaciente;
    private String tipoAlerta;
    private String descripcion;
    private LocalDateTime fechaGeneracion;
    private boolean atendida;

    public Alerta(Long id, Long idPaciente, String tipoAlerta, String descripcion) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.tipoAlerta = tipoAlerta;
        this.descripcion = descripcion;
        this.fechaGeneracion = LocalDateTime.now();
        this.atendida = false;
    }

    public Alerta(Long id, Long idPaciente, String tipoAlerta, String descripcion,
                  LocalDateTime fechaGeneracion, boolean atendida) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.tipoAlerta = tipoAlerta;
        this.descripcion = descripcion;
        this.fechaGeneracion = fechaGeneracion;
        this.atendida = atendida;
    }

    public void atender() {
        if (atendida) {
            throw new IllegalStateException("La alerta ya fue atendida");
        }
        atendida = true;
    }

    public Long getId() {
        return id;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public boolean isAtendida() {
        return atendida;
    }
}
