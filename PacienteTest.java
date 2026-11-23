package com.clinica.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PacienteTest {

    @Test
    void pacienteNuevoEmpiezaConRiesgoBajo(){
        Paciente paciente = new Paciente( null, "Ana", "anamaria@pascualbravo.edu.co");

        assertEquals ("BAJO", paciente.getNivelRiesgo());
    }

    @Test
    void conDosInasistenciasElRiesgoPasaAMedio(){
        Paciente paciente = new Paciente(null, "Ana", "anamaria@pascualbravo.edu.co");

        paciente.registrarInasistencia();
        paciente.registrarInasistencia();

        assertEquals("MEDIO",paciente.getNivelRiesgo());
    }

    @Test

    void conTresInasistenciasElRiesgoPasaAAltoYRequiereSeguimiento(){
        Paciente paciente = new Paciente(null, "Ana", "anamaria@pascualbravo.edu.co");

        paciente.registrarInasistencia();
        paciente.registrarInasistencia();
        paciente.registrarInasistencia();

        assertEquals("ALTO",paciente.getNivelRiesgo());
        assertTrue(paciente.isRequiereSeguimiento());

    }