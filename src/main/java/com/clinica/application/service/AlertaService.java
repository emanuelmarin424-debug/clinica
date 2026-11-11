package com.clinica.application.service;

import com.clinica.domain.model.Alerta;
import com.clinica.domain.port.AlertaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlertaService {

    private final AlertaRepository repository;

    public AlertaService(AlertaRepository repository) {
        this.repository = repository;
    }

    public List<Alerta> listar() {
        return repository.listar();
    }

    public List<Alerta> listarPendientes() {
        List<Alerta> pendientes = new ArrayList<>();
        for (Alerta a : repository.listar()) {
            if (!a.isAtendida()) {
                pendientes.add(a);
            }
        }
        return pendientes;
    }

    public Alerta atenderAlerta(Long id) {
        Alerta alerta = repository.buscarPorId(id);
        alerta.atender();
        return repository.guardar(alerta);
    }
}
