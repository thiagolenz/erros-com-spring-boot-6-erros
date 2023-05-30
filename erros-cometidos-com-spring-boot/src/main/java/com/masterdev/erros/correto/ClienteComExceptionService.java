package com.masterdev.erros.correto;

import com.masterdev.erros.cliente.Cliente;
import com.masterdev.erros.cliente.ClienteRepository;
import com.masterdev.erros.exceptions.ClienteExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteComExceptionService {
    @Autowired
    private ClienteRepository repository;

    public Cliente create(Cliente cliente) {
        if (repository.findByCpf(cliente.getCpf())) {
            throw new ClienteExistenteException("Cliente Existente", cliente.getCpf());
        }
        return repository.save(cliente);
    }

    public Cliente getById(Long id) {
        return repository.getReferenceById(id);
    }
}
