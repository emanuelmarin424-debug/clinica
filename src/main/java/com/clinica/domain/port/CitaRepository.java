package com.clinica.domain.port;

import com.clinica.domain.model.Cita;

import java.util.List;

public interface CitaRepository {

    Cita guardar(Cita cita);

    Cita buscarPorId(Long id);

    List<Cita> listar();
}
