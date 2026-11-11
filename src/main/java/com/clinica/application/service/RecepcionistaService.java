package com.clinica.application.service;

import com.clinica.domain.model.Recepcionista;
import com.clinica.domain.port.RecepcionistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecepcionistaService {

    private final RecepcionistaRepository repository;

    public RecepcionistaService(RecepcionistaRepository repository) {
        this.repository = repository;
    }

    public Recepcionista registrarRecepcionista(String nombre, String correo, String turno) {
        Recepcionista recepcionista = new Recepcionista(null, nombre, correo, turno);
        return repository.guardar(recepcionista);
    }

    public List<Recepcionista> listar() {
        return repository.listar();
    }
}
