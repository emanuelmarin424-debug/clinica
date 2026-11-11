package com.clinica.application.service;

import com.clinica.domain.model.SeguimientoClinico;
import com.clinica.domain.port.MedicoRepository;
import com.clinica.domain.port.PacienteRepository;
import com.clinica.domain.port.SeguimientoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeguimientoService {

    private final SeguimientoRepository seguimientoRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public SeguimientoService(SeguimientoRepository seguimientoRepository,
                              PacienteRepository pacienteRepository,
                              MedicoRepository medicoRepository) {
        this.seguimientoRepository = seguimientoRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
    }

    public SeguimientoClinico registrarSeguimiento(Long idPaciente, Long idMedico,
                                                   String observaciones, String recomendaciones) {
        pacienteRepository.buscarPorId(idPaciente);
        medicoRepository.buscarPorId(idMedico);

        SeguimientoClinico seguimiento = new SeguimientoClinico(null, idPaciente, idMedico,
                LocalDate.now(), observaciones, recomendaciones);
        return seguimientoRepository.guardar(seguimiento);
    }

    public List<SeguimientoClinico> historialDePaciente(Long idPaciente) {
        List<SeguimientoClinico> historial = new ArrayList<>();
        for (SeguimientoClinico s : seguimientoRepository.listar()) {
            if (s.getIdPaciente().equals(idPaciente)) {
                historial.add(s);
            }
        }
        return historial;
    }
}
