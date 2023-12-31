package med.voll.api.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import med.voll.api.domain.ValidacaoException;

import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class TratamentoErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity erro404() {

        return ResponseEntity.notFound().build();

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity erro400(MethodArgumentNotValidException ex) {

        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(dadosErrosValidacao::new).toList());

    }

    private record dadosErrosValidacao(String campo, String menssagem) {

        public dadosErrosValidacao(FieldError erro){

            this(erro.getField(), erro.getDefaultMessage());

        }


    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity regraDeNegocio(ValidacaoException ex) {

        return ResponseEntity.badRequest().body(ex.getMessage());

    }


}
