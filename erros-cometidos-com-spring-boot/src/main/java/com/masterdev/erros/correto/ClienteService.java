package com.masterdev.erros.correto;

import com.masterdev.erros.cliente.Cliente;
import com.masterdev.erros.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente salvar (Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente getById(Long id) {
        return repository.getReferenceById(id);
    }
}
