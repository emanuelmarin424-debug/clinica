package com.clinica.application.service;

import com.clinica.domain.model.Alerta;
import com.clinica.domain.model.Cita;
import com.clinica.domain.model.Paciente;
import com.clinica.domain.port.AlertaRepository;
import com.clinica.domain.port.CitaRepository;
import com.clinica.domain.port.MedicoRepository;
import com.clinica.domain.port.PacienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CitaService {

    private final CitaRepository citaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;
    private final AlertaRepository alertaRepository;

    public CitaService(CitaRepository citaRepository, PacienteRepository pacienteRepository,
                       MedicoRepository medicoRepository, AlertaRepository alertaRepository) {
        this.citaRepository = citaRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
        this.alertaRepository = alertaRepository;
    }

    public Cita agendarCita(Long idPaciente, Long idMedico, LocalDateTime fechaHora) {
        // si el paciente o el medico no existen, buscarPorId lanza error
        pacienteRepository.buscarPorId(idPaciente);
        medicoRepository.buscarPorId(idMedico);

        // el medico no puede tener dos citas a la misma hora
        for (Cita c : citaRepository.listar()) {
            if (c.getIdMedico().equals(idMedico) && c.getFechaHora().equals(fechaHora)
                    && c.getEstado().equals("PROGRAMADA")) {
                throw new IllegalArgumentException("El medico ya tiene una cita a esa hora");
            }
        }

        Cita cita = new Cita(null, idPaciente, idMedico, fechaHora);
        return citaRepository.guardar(cita);
    }

    public List<Cita> listar() {
        return citaRepository.listar();
    }

    public List<Cita> listarPorPaciente(Long idPaciente) {
        List<Cita> resultado = new ArrayList<>();
        for (Cita c : citaRepository.listar()) {
            if (c.getIdPaciente().equals(idPaciente)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public Cita cancelarCita(Long id, String motivo) {
        Cita cita = citaRepository.buscarPorId(id);
        cita.cancelar(motivo);
        return citaRepository.guardar(cita);
    }

    public Cita atenderCita(Long id) {
        Cita cita = citaRepository.buscarPorId(id);
        cita.atender();
        return citaRepository.guardar(cita);
    }

    public Cita registrarInasistencia(Long id) {
        Cita cita = citaRepository.buscarPorId(id);
        cita.marcarInasistencia();

        Paciente paciente = pacienteRepository.buscarPorId(cita.getIdPaciente());
        paciente.registrarInasistencia();
        pacienteRepository.guardar(paciente);

        // la alerta se genera cuando completa 3 inasistencias
        if (paciente.getContadorInasistencias() == 3) {
            Alerta alerta = new Alerta(null, paciente.getId(), "INASISTENCIAS",
                    "El paciente " + paciente.getNombre() + " tiene 3 inasistencias");
            alertaRepository.guardar(alerta);
        }

        return citaRepository.guardar(cita);
    }
}
