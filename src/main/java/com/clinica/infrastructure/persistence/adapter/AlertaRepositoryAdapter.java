package com.clinica.infrastructure.persistence.adapter;

import com.clinica.domain.model.Alerta;
import com.clinica.domain.port.AlertaRepository;
import com.clinica.infrastructure.persistence.entity.AlertaEntity;
import com.clinica.infrastructure.persistence.repository.SpringDataAlertaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlertaRepositoryAdapter implements AlertaRepository {

    private final SpringDataAlertaRepository repository;

    public AlertaRepositoryAdapter(SpringDataAlertaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Alerta guardar(Alerta alerta) {
        AlertaEntity entity = convertirAEntity(alerta);
        AlertaEntity guardado = repository.save(entity);
        return convertirADominio(guardado);
    }

    @Override
    public Alerta buscarPorId(Long id) {
        AlertaEntity entity = repository.findById(id).orElse(null);
        if (entity == null) {
            throw new IllegalArgumentException("Alerta no encontrada");
        }
        return convertirADominio(entity);
    }

    @Override
    public List<Alerta> listar() {
        List<Alerta> lista = new ArrayList<>();
        for (AlertaEntity entity : repository.findAll()) {
            lista.add(convertirADominio(entity));
        }
        return lista;
    }

    private AlertaEntity convertirAEntity(Alerta alerta) {
        AlertaEntity entity = new AlertaEntity();
        entity.setId(alerta.getId());
        entity.setIdPaciente(alerta.getIdPaciente());
        entity.setTipoAlerta(alerta.getTipoAlerta());
        entity.setDescripcion(alerta.getDescripcion());
        entity.setFechaGeneracion(alerta.getFechaGeneracion());
        entity.setAtendida(alerta.isAtendida());
        return entity;
    }

    private Alerta convertirADominio(AlertaEntity entity) {
        return new Alerta(
                entity.getId(),
                entity.getIdPaciente(),
                entity.getTipoAlerta(),
                entity.getDescripcion(),
                entity.getFechaGeneracion(),
                entity.isAtendida()
        );
    }
}
