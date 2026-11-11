package com.clinica.infrastructure.controller;

import com.clinica.application.service.SeguimientoService;
import com.clinica.domain.model.SeguimientoClinico;
import com.clinica.infrastructure.controller.dto.SeguimientoRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/seguimientos")
public class SeguimientoController {

    private final SeguimientoService seguimientoService;

    public SeguimientoController(SeguimientoService seguimientoService) {
        this.seguimientoService = seguimientoService;
    }

    @PostMapping
    public SeguimientoClinico registrar(@RequestBody SeguimientoRequest request) {
        return seguimientoService.registrarSeguimiento(request.idPaciente(), request.idMedico(),
                request.observaciones(), request.recomendaciones());
    }

    @GetMapping("/paciente/{idPaciente}")
    public List<SeguimientoClinico> historial(@PathVariable Long idPaciente) {
        return seguimientoService.historialDePaciente(idPaciente);
    }
}
