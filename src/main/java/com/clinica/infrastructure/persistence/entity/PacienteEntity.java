package com.clinica.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "paciente")
@PrimaryKeyJoinColumn(name = "id_paciente")
public class PacienteEntity extends UsuarioEntity {

    @Column(name = "nivel_riesgo")
    private String nivelRiesgo;

    @Column(name = "contador_inasistencias")
    private int contadorInasistencias;

    @Column(name = "requiere_seguimiento")
    private boolean requiereSeguimiento;

    public PacienteEntity() {
    }

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public int getContadorInasistencias() {
        return contadorInasistencias;
    }

    public void setContadorInasistencias(int contadorInasistencias) {
        this.contadorInasistencias = contadorInasistencias;
    }

    public boolean isRequiereSeguimiento() {
        return requiereSeguimiento;
    }

    public void setRequiereSeguimiento(boolean requiereSeguimiento) {
        this.requiereSeguimiento = requiereSeguimiento;
    }
}
