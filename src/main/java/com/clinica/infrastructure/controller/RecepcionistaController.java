package com.clinica.infrastructure.controller;

import com.clinica.application.service.RecepcionistaService;
import com.clinica.domain.model.Recepcionista;
import com.clinica.infrastructure.controller.dto.RecepcionistaRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/recepcionistas")
public class RecepcionistaController {

    private final RecepcionistaService recepcionistaService;

    public RecepcionistaController(RecepcionistaService recepcionistaService) {
        this.recepcionistaService = recepcionistaService;
    }

    @PostMapping
    public Recepcionista registrar(@RequestBody RecepcionistaRequest request) {
        return recepcionistaService.registrarRecepcionista(request.nombre(), request.correo(), request.turno());
    }

    @GetMapping
    public List<Recepcionista> listar() {
        return recepcionistaService.listar();
    }
}
