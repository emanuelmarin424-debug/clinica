package com.clinica.infrastructure.controller;

import com.clinica.application.service.CitaService;
import com.clinica.domain.model.Cita;
import com.clinica.infrastructure.controller.dto.CancelarCitaRequest;
import com.clinica.infrastructure.controller.dto.CitaRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @PostMapping
    public Cita agendar(@RequestBody CitaRequest request) {
        return citaService.agendarCita(request.idPaciente(), request.idMedico(), request.fechaHora());
    }

    @GetMapping
    public List<Cita> listar() {
        return citaService.listar();
    }

    @PutMapping("/{id}/cancelar")
    public Cita cancelar(@PathVariable Long id, @RequestBody CancelarCitaRequest request) {
        return citaService.cancelarCita(id, request.motivo());
    }

    @PutMapping("/{id}/atender")
    public Cita atender(@PathVariable Long id) {
        return citaService.atenderCita(id);
    }

    @PutMapping("/{id}/inasistencia")
    public Cita inasistencia(@PathVariable Long id) {
        return citaService.registrarInasistencia(id);
    }
}
