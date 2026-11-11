package com.clinica.domain.port;

import com.clinica.domain.model.SeguimientoClinico;

import java.util.List;

public interface SeguimientoRepository {

    SeguimientoClinico guardar(SeguimientoClinico seguimiento);

    List<SeguimientoClinico> listar();
}
