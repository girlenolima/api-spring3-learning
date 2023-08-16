package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;

public class ValidadorMedicoAtivo {

    //Nao esta sendo injetado pelo Spring
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        if (dados.idMedico() == null) {
            return;
        }

        var medicoAtivo = repository.findAtivoById(dados.idMedico());
        if(!medicoAtivo){

                throw new ValidacaoException("Consulta nao pode ser agendada com medico nao ativo");
        }

    }

}
