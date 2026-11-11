package com.clinica.infrastructure.persistence.adapter;

import com.clinica.domain.model.Cita;
import com.clinica.domain.port.CitaRepository;
import com.clinica.infrastructure.persistence.entity.CitaEntity;
import com.clinica.infrastructure.persistence.repository.SpringDataCitaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CitaRepositoryAdapter implements CitaRepository {

    private final SpringDataCitaRepository repository;

    public CitaRepositoryAdapter(SpringDataCitaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cita guardar(Cita cita) {
        CitaEntity entity = convertirAEntity(cita);
        CitaEntity guardado = repository.save(entity);
        return convertirADominio(guardado);
    }

    @Override
    public Cita buscarPorId(Long id) {
        CitaEntity entity = repository.findById(id).orElse(null);
        if (entity == null) {
            throw new IllegalArgumentException("Cita no encontrada");
        }
        return convertirADominio(entity);
    }

    @Override
    public List<Cita> listar() {
        List<Cita> lista = new ArrayList<>();
        for (CitaEntity entity : repository.findAll()) {
            lista.add(convertirADominio(entity));
        }
        return lista;
    }

    private CitaEntity convertirAEntity(Cita cita) {
        CitaEntity entity = new CitaEntity();
        entity.setId(cita.getId());
        entity.setIdPaciente(cita.getIdPaciente());
        entity.setIdMedico(cita.getIdMedico());
        entity.setFechaHora(cita.getFechaHora());
        entity.setEstado(cita.getEstado());
        entity.setMotivoCancelacion(cita.getMotivoCancelacion());
        return entity;
    }

    private Cita convertirADominio(CitaEntity entity) {
        return new Cita(
                entity.getId(),
                entity.getIdPaciente(),
                entity.getIdMedico(),
                entity.getFechaHora(),
                entity.getEstado(),
                entity.getMotivoCancelacion()
        );
    }
}
