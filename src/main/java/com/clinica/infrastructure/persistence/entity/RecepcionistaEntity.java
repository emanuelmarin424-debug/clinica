package com.clinica.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recepcionista")
@PrimaryKeyJoinColumn(name = "id_recepcionista")
public class RecepcionistaEntity extends UsuarioEntity {

    private String turno;

    public RecepcionistaEntity() {
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
