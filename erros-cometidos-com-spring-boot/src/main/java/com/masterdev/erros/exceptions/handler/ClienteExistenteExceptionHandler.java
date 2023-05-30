package com.masterdev.erros.exceptions.handler;

import com.masterdev.erros.exceptions.ClienteExistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ControllerAdvice
public class ClienteExistenteExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    @ExceptionHandler(ClienteExistenteException.class)
    public ErrorDTO handler(ClienteExistenteException ex) {
        return new ErrorDTO(
            MessageFormat.format("O cliente com cpf %s já existe! Mais detalhes: ", ex.getCpf(), ex.getMessage())
        );
    }
}
