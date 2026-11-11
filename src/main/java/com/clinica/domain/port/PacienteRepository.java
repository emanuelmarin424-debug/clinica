package com.clinica.domain.port;

import com.clinica.domain.model.Paciente;

import java.util.List;

public interface PacienteRepository {

    Paciente guardar(Paciente paciente);

    Paciente buscarPorId(Long id);

    List<Paciente> listar();
}
