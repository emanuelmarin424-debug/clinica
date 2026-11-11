package com.clinica.infrastructure.controller;

import com.clinica.application.service.AlertaService;
import com.clinica.domain.model.Alerta;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/alertas")
public class AlertaController {

    private final AlertaService alertaService;

    public AlertaController(AlertaService alertaService) {
        this.alertaService = alertaService;
    }

    @GetMapping
    public List<Alerta> listar() {
        return alertaService.listar();
    }

    @GetMapping("/pendientes")
    public List<Alerta> pendientes() {
        return alertaService.listarPendientes();
    }

    @PutMapping("/{id}/atender")
    public Alerta atender(@PathVariable Long id) {
        return alertaService.atenderAlerta(id);
    }
}
