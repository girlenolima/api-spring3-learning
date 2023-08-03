package med.voll.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

                @NotBlank(message = "logradouro é obrigatório")
                String logradouro,

                @NotBlank(message = "bairro é obrigatório")
                String bairro,

                @NotBlank(message = "cep é obrigatório")
                @Pattern(regexp = "\\d{8}", message = "cep no formato errado.") 
                String cep,

                String cidade,

                @NotBlank(message = "cep é obrigatório")
                String uf,

                String complemento,

                String numero) {

}
