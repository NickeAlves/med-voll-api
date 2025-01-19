package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClina = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClina = dataConsulta.getHour() > 18;

        if (domingo || antesDaAberturaDaClina || depoisDoEncerramentoDaClina) {
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica.");
        }

    }
}
