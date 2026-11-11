package com.clinica.application.service;

import com.clinica.domain.model.Paciente;
import com.clinica.domain.port.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public Paciente registrarPaciente(String nombre, String correo) {
        Paciente paciente = new Paciente(null, nombre, correo);
        return repository.guardar(paciente);
    }

    public List<Paciente> listar() {
        return repository.listar();
    }

    public Paciente buscar(Long id) {
        return repository.buscarPorId(id);
    }
}
