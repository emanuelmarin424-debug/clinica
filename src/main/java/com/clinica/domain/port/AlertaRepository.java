package com.clinica.domain.port;

import com.clinica.domain.model.Alerta;

import java.util.List;

public interface AlertaRepository {

    Alerta guardar(Alerta alerta);

    Alerta buscarPorId(Long id);

    List<Alerta> listar();
}
