package com.clinica.domain.model;

public class Recepcionista extends Usuario {

    private String turno;

    public Recepcionista(Long id, String nombre, String correo, String turno) {
        super(id, nombre, correo, "RECEPCIONISTA");
        if (turno == null || turno.isBlank()) {
            throw new IllegalArgumentException("El turno es obligatorio");
        }
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }
}
