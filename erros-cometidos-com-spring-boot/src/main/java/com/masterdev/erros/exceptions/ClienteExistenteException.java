package com.masterdev.erros.exceptions;

public class ClienteExistenteException extends RuntimeException{
    private final String cpf;

    public ClienteExistenteException(String message, String cpf) {
        super(message);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
