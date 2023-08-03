package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.enuns.Especialidade;

public record DadosCadastroMedicos(
   
    @NotBlank
    String nome, 

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Formato do email é inválido")
    String email, 

    @NotBlank(message = "Telefone é obrigatório")
    String telefone,

    @NotBlank(message = "CRM é obrigatório")
    @Pattern(regexp = "\\d{4,6}" , message = "CRM invalido")
    String crm,

    @NotNull(message = "Especialidade é obrigatória")
    Especialidade especialidade, 

    @NotNull(message = "Especialidade é obrigatória")
    @Valid
    DadosEndereco endereco) {



}
