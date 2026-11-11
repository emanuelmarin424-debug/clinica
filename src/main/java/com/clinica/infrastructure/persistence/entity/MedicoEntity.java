package com.clinica.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medico")
@PrimaryKeyJoinColumn(name = "id_medico")
public class MedicoEntity extends UsuarioEntity {

    private String especialidad;

    public MedicoEntity() {
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
