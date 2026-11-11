package com.clinica.infrastructure.persistence.adapter;

import com.clinica.domain.model.Medico;
import com.clinica.domain.port.MedicoRepository;
import com.clinica.infrastructure.persistence.entity.MedicoEntity;
import com.clinica.infrastructure.persistence.repository.SpringDataMedicoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicoRepositoryAdapter implements MedicoRepository {

    private final SpringDataMedicoRepository repository;

    public MedicoRepositoryAdapter(SpringDataMedicoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Medico guardar(Medico medico) {
        MedicoEntity entity = convertirAEntity(medico);
        MedicoEntity guardado = repository.save(entity);
        return convertirADominio(guardado);
    }

    @Override
    public Medico buscarPorId(Long id) {
        MedicoEntity entity = repository.findById(id).orElse(null);
        if (entity == null) {
            throw new IllegalArgumentException("Medico no encontrado");
        }
        return convertirADominio(entity);
    }

    @Override
    public List<Medico> listar() {
        List<Medico> lista = new ArrayList<>();
        for (MedicoEntity entity : repository.findAll()) {
            lista.add(convertirADominio(entity));
        }
        return lista;
    }

    private MedicoEntity convertirAEntity(Medico medico) {
        MedicoEntity entity = new MedicoEntity();
        entity.setId(medico.getId());
        entity.setNombre(medico.getNombre());
        entity.setCorreo(medico.getCorreo());
        entity.setRol(medico.getRol());
        entity.setEspecialidad(medico.getEspecialidad());
        return entity;
    }

    private Medico convertirADominio(MedicoEntity entity) {
        return new Medico(
                entity.getId(),
                entity.getNombre(),
                entity.getCorreo(),
                entity.getEspecialidad()
        );
    }
}
