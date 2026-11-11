package com.clinica.infrastructure.persistence.adapter;

import com.clinica.domain.model.SeguimientoClinico;
import com.clinica.domain.port.SeguimientoRepository;
import com.clinica.infrastructure.persistence.entity.SeguimientoClinicoEntity;
import com.clinica.infrastructure.persistence.repository.SpringDataSeguimientoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SeguimientoRepositoryAdapter implements SeguimientoRepository {

    private final SpringDataSeguimientoRepository repository;

    public SeguimientoRepositoryAdapter(SpringDataSeguimientoRepository repository) {
        this.repository = repository;
    }

    @Override
    public SeguimientoClinico guardar(SeguimientoClinico seguimiento) {
        SeguimientoClinicoEntity entity = convertirAEntity(seguimiento);
        SeguimientoClinicoEntity guardado = repository.save(entity);
        return convertirADominio(guardado);
    }

    @Override
    public List<SeguimientoClinico> listar() {
        List<SeguimientoClinico> lista = new ArrayList<>();
        for (SeguimientoClinicoEntity entity : repository.findAll()) {
            lista.add(convertirADominio(entity));
        }
        return lista;
    }

    private SeguimientoClinicoEntity convertirAEntity(SeguimientoClinico seguimiento) {
        SeguimientoClinicoEntity entity = new SeguimientoClinicoEntity();
        entity.setId(seguimiento.getId());
        entity.setIdPaciente(seguimiento.getIdPaciente());
        entity.setIdMedico(seguimiento.getIdMedico());
        entity.setFecha(seguimiento.getFecha());
        entity.setObservaciones(seguimiento.getObservaciones());
        entity.setRecomendaciones(seguimiento.getRecomendaciones());
        return entity;
    }

    private SeguimientoClinico convertirADominio(SeguimientoClinicoEntity entity) {
        return new SeguimientoClinico(
                entity.getId(),
                entity.getIdPaciente(),
                entity.getIdMedico(),
                entity.getFecha(),
                entity.getObservaciones(),
                entity.getRecomendaciones()
        );
    }
}
