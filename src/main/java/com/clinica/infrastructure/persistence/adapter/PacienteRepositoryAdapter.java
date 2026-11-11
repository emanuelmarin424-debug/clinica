package com.clinica.infrastructure.persistence.adapter;

import com.clinica.domain.model.Paciente;
import com.clinica.domain.port.PacienteRepository;
import com.clinica.infrastructure.persistence.entity.PacienteEntity;
import com.clinica.infrastructure.persistence.repository.SpringDataPacienteRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PacienteRepositoryAdapter implements PacienteRepository {

    private final SpringDataPacienteRepository repository;

    public PacienteRepositoryAdapter(SpringDataPacienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        PacienteEntity entity = convertirAEntity(paciente);
        PacienteEntity guardado = repository.save(entity);
        return convertirADominio(guardado);
    }

    @Override
    public Paciente buscarPorId(Long id) {
        PacienteEntity entity = repository.findById(id).orElse(null);
        if (entity == null) {
            throw new IllegalArgumentException("Paciente no encontrado");
        }
        return convertirADominio(entity);
    }

    @Override
    public List<Paciente> listar() {
        List<Paciente> lista = new ArrayList<>();
        for (PacienteEntity entity : repository.findAll()) {
            lista.add(convertirADominio(entity));
        }
        return lista;
    }

    private PacienteEntity convertirAEntity(Paciente paciente) {
        PacienteEntity entity = new PacienteEntity();
        entity.setId(paciente.getId());
        entity.setNombre(paciente.getNombre());
        entity.setCorreo(paciente.getCorreo());
        entity.setRol(paciente.getRol());
        entity.setNivelRiesgo(paciente.getNivelRiesgo());
        entity.setContadorInasistencias(paciente.getContadorInasistencias());
        entity.setRequiereSeguimiento(paciente.isRequiereSeguimiento());
        return entity;
    }

    private Paciente convertirADominio(PacienteEntity entity) {
        return new Paciente(
                entity.getId(),
                entity.getNombre(),
                entity.getCorreo(),
                entity.getNivelRiesgo(),
                entity.getContadorInasistencias(),
                entity.isRequiereSeguimiento()
        );
    }
}
