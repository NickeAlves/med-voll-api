package med.voll.api.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Boolean existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(Long id, LocalDateTime data);
    Boolean existsByPacienteIdAndDataBetween( Long idPaciente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}

