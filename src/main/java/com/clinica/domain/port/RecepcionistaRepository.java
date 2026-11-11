package com.clinica.domain.port;

import com.clinica.domain.model.Recepcionista;

import java.util.List;

public interface RecepcionistaRepository {

    Recepcionista guardar(Recepcionista recepcionista);

    Recepcionista buscarPorId(Long id);

    List<Recepcionista> listar();
}
