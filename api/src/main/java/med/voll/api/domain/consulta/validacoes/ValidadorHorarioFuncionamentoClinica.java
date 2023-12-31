package med.voll.api.domain.consulta.validacoes;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsulta dados) {

        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisEncerramentoDaClinica = dataConsulta.getHour() >= 18;

        if (domingo || antesAberturaDaClinica || depoisEncerramentoDaClinica) {

            throw new ValidacaoException("Consulta fora do horario de funcionamento da clinica");

        }

    }

}
