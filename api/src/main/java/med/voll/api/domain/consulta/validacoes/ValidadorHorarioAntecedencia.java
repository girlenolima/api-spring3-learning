package med.voll.api.domain.consulta.validacoes;


import java.time.Duration;
import java.time.LocalDateTime;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorHorarioAntecedencia {

     public void validar(DadosAgendamentoConsulta dados) {

        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();

        var diferenceEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        
        if (diferenceEmMinutos < 30) {

            throw new ValidacaoException("Consulta deve ser agendada com antecedencia de 30 minutos");

        }


    }

    
}
