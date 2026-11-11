package com.clinica.domain.model;

public class Paciente extends Usuario {

    private String nivelRiesgo;
    private int contadorInasistencias;
    private boolean requiereSeguimiento;

    // cuando se registra un paciente nuevo
    public Paciente(Long id, String nombre, String correo) {
        super(id, nombre, correo, "PACIENTE");
        this.nivelRiesgo = "BAJO";
        this.contadorInasistencias = 0;
        this.requiereSeguimiento = false;
    }

    // cuando se lee de la base de datos
    public Paciente(Long id, String nombre, String correo, String nivelRiesgo,
                    int contadorInasistencias, boolean requiereSeguimiento) {
        super(id, nombre, correo, "PACIENTE");
        this.nivelRiesgo = nivelRiesgo;
        this.contadorInasistencias = contadorInasistencias;
        this.requiereSeguimiento = requiereSeguimiento;
    }

    // con 2 faltas pasa a riesgo medio y con 3 a riesgo alto
    public void registrarInasistencia() {
        contadorInasistencias = contadorInasistencias + 1;

        if (contadorInasistencias == 2) {
            nivelRiesgo = "MEDIO";
        }
        if (contadorInasistencias >= 3) {
            nivelRiesgo = "ALTO";
            requiereSeguimiento = true;
        }
    }

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public int getContadorInasistencias() {
        return contadorInasistencias;
    }

    public boolean isRequiereSeguimiento() {
        return requiereSeguimiento;
    }
}
