package com.clinica.infrastructure.controller;

import com.clinica.application.service.MedicoService;
import com.clinica.domain.model.Medico;
import com.clinica.infrastructure.controller.dto.MedicoRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public Medico registrar(@RequestBody MedicoRequest request) {
        return medicoService.registrarMedico(request.nombre(), request.correo(), request.especialidad());
    }

    @GetMapping
    public List<Medico> listar() {
        return medicoService.listar();
    }
}
