package com.clinica.domain.port;

import com.clinica.domain.model.Medico;

import java.util.List;

public interface MedicoRepository {

    Medico guardar(Medico medico);

    Medico buscarPorId(Long id);

    List<Medico> listar();
}
