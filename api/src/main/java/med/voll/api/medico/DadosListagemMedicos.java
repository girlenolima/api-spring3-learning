package med.voll.api.medico;

import med.voll.api.endereco.Endereco;
import med.voll.api.enuns.Especialidade;

public record DadosListagemMedicos(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        Endereco endereco) {

    public DadosListagemMedicos(Medico medico) {

        this(medico.getId(),medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());

    }

}
