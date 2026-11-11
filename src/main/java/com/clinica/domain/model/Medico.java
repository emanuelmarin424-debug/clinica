package com.clinica.domain.model;

public class Medico extends Usuario {

    private String especialidad;

    public Medico(Long id, String nombre, String correo, String especialidad) {
        super(id, nombre, correo, "MEDICO");
        if (especialidad == null || especialidad.isBlank()) {
            throw new IllegalArgumentException("La especialidad es obligatoria");
        }
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
