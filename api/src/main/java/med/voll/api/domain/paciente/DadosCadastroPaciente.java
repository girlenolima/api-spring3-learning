package med.voll.api.domain.paciente;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;



public record DadosCadastroPaciente(
       
        @NotBlank(message = "nome é obrigatório")
        String nome,

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato do e-mail é invalido")
        String email,

        @NotBlank (message = "telefone é obrigatório")
        String telefone, 

        @NotBlank(message = "cpf é obrigatório")
        String cpf,

        @NotNull
        @Valid
        DadosEndereco endereco) {

}
