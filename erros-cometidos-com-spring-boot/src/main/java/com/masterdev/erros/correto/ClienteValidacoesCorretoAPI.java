package com.masterdev.erros.correto;

import com.masterdev.erros.cliente.Cliente;
import com.masterdev.erros.cliente.ClienteRepository;
import com.masterdev.erros.converter.ClienteConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/correto/cliente-validacoes")
@RestController
public class ClienteValidacoesCorretoAPI {
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteService service;


    @PostMapping
    public ClienteResponseDTO salvar(@RequestBody @Validated ClienteRequestDTO request) {
        Cliente clienteSalvo = service.salvar(new Cliente(
            request.getNome(),
            request.getEndereco(),
            request.getCpf()
        ));

        return ClienteConverter.converter(clienteSalvo);
    }
}
