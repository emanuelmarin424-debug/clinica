package com.clinica.infrastructure.persistence.adapter;

import com.clinica.domain.model.Recepcionista;
import com.clinica.domain.port.RecepcionistaRepository;
import com.clinica.infrastructure.persistence.entity.RecepcionistaEntity;
import com.clinica.infrastructure.persistence.repository.SpringDataRecepcionistaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecepcionistaRepositoryAdapter implements RecepcionistaRepository {

    private final SpringDataRecepcionistaRepository repository;

    public RecepcionistaRepositoryAdapter(SpringDataRecepcionistaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Recepcionista guardar(Recepcionista recepcionista) {
        RecepcionistaEntity entity = convertirAEntity(recepcionista);
        RecepcionistaEntity guardado = repository.save(entity);
        return convertirADominio(guardado);
    }

    @Override
    public Recepcionista buscarPorId(Long id) {
        RecepcionistaEntity entity = repository.findById(id).orElse(null);
        if (entity == null) {
            throw new IllegalArgumentException("Recepcionista no encontrado");
        }
        return convertirADominio(entity);
    }

    @Override
    public List<Recepcionista> listar() {
        List<Recepcionista> lista = new ArrayList<>();
        for (RecepcionistaEntity entity : repository.findAll()) {
            lista.add(convertirADominio(entity));
        }
        return lista;
    }

    private RecepcionistaEntity convertirAEntity(Recepcionista recepcionista) {
        RecepcionistaEntity entity = new RecepcionistaEntity();
        entity.setId(recepcionista.getId());
        entity.setNombre(recepcionista.getNombre());
        entity.setCorreo(recepcionista.getCorreo());
        entity.setRol(recepcionista.getRol());
        entity.setTurno(recepcionista.getTurno());
        return entity;
    }

    private Recepcionista convertirADominio(RecepcionistaEntity entity) {
        return new Recepcionista(
                entity.getId(),
                entity.getNombre(),
                entity.getCorreo(),
                entity.getTurno()
        );
    }
}
