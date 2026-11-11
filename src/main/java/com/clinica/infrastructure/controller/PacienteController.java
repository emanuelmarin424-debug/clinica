package com.clinica.infrastructure.controller;

import com.clinica.application.service.CitaService;
import com.clinica.application.service.PacienteService;
import com.clinica.domain.model.Cita;
import com.clinica.domain.model.Paciente;
import com.clinica.infrastructure.controller.dto.PacienteRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;
    private final CitaService citaService;

    public PacienteController(PacienteService pacienteService, CitaService citaService) {
        this.pacienteService = pacienteService;
        this.citaService = citaService;
    }

    @PostMapping
    public Paciente registrar(@RequestBody PacienteRequest request) {
        return pacienteService.registrarPaciente(request.nombre(), request.correo());
    }

    @GetMapping
    public List<Paciente> listar() {
        return pacienteService.listar();
    }

    @GetMapping("/{id}")
    public Paciente buscar(@PathVariable Long id) {
        return pacienteService.buscar(id);
    }

    @GetMapping("/{id}/citas")
    public List<Cita> citasDelPaciente(@PathVariable Long id) {
        return citaService.listarPorPaciente(id);
    }
}
