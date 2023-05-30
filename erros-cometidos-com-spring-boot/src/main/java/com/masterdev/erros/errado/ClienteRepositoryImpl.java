package com.masterdev.erros.errado;

import com.masterdev.erros.cliente.Cliente;
import com.masterdev.erros.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepositoryImpl{
    @Autowired private ClienteRepository repository;

    public Cliente getReferenceById(Long id) {
        return null;
    }

    public Cliente save(Cliente request) {
        return null;
    }
}
