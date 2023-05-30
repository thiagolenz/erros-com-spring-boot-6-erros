package com.masterdev.erros.errado;

import com.masterdev.erros.cliente.Cliente;
import com.masterdev.erros.cliente.ClienteRepository;
import com.masterdev.erros.exceptions.ClienteExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteSearchService {
    @Autowired
    private ClienteRepository repository;

    public List<Cliente> getAllCustomers() {
        return repository.findAll();
    }

    public List<Cliente> getConsultaPaginada (Integer numPagina, Integer numRegistros) {
        Pageable pageRequest = PageRequest.of(numPagina, numRegistros);
        Page<Cliente> result = repository.findAll(pageRequest);
        return result.stream().toList();
    }
}
