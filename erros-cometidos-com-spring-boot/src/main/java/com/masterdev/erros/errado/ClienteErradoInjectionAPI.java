package com.masterdev.erros.errado;

import com.masterdev.erros.cliente.Cliente;
import com.masterdev.erros.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/errado/cliente")
@RestController
public class ClienteErradoInjectionAPI {

    @Autowired
    private ClienteRepositoryImpl repository;

//    public ClienteErradoInjectionAPI() {
//        repository = new ClienteRepositoryImpl();
//    }

    @GetMapping("/{id}")
    public Cliente getById(@PathVariable("id") Long id) {
        return repository.getReferenceById(id);
    }

    @PostMapping
    public Cliente salvar(@RequestBody Cliente request) {
        return repository.save(request);
    }
}
