package com.masterdev.erros.errado;

import com.masterdev.erros.cliente.Cliente;
import com.masterdev.erros.cliente.ClienteRepository;
import com.masterdev.erros.converter.ClienteConverter;
import com.masterdev.erros.correto.ClienteRequestDTO;
import com.masterdev.erros.correto.ClienteResponseDTO;
import com.masterdev.erros.correto.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/errado/cliente-validacoes")
@RestController
public class ClienteValidacoesErradoAPI {
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteService service;

    @PostMapping
    public ClienteResponseDTO salvar(@RequestBody ClienteRequestDTO request) {
        if (request.getCpf() != null && request.getCpf().trim().length() > 0) {
            Cliente clienteSalvo = service.salvar(new Cliente(
                request.getNome(),
                request.getEndereco(),
                request.getCpf()
            ));

            return ClienteConverter.converter(clienteSalvo);
        }
        return null;
    }
}
