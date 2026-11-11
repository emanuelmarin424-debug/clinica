package com.clinica.application.service;

import com.clinica.domain.model.Medico;
import com.clinica.domain.port.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public Medico registrarMedico(String nombre, String correo, String especialidad) {
        Medico medico = new Medico(null, nombre, correo, especialidad);
        return repository.guardar(medico);
    }

    public List<Medico> listar() {
        return repository.listar();
    }
}
