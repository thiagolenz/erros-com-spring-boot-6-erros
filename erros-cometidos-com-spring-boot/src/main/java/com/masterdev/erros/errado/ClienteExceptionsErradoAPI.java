package com.masterdev.erros.errado;

import com.masterdev.erros.cliente.Cliente;
import com.masterdev.erros.cliente.ClienteRepository;
import com.masterdev.erros.converter.ClienteConverter;
import com.masterdev.erros.correto.ClienteComExceptionService;
import com.masterdev.erros.correto.ClienteRequestDTO;
import com.masterdev.erros.correto.ClienteService;
import com.masterdev.erros.exceptions.ClienteExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/errado/cliente-exceptions")
@RestController
public class ClienteExceptionsErradoAPI {
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteComExceptionService service;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Validated ClienteRequestDTO request) {
        try {
            Cliente clienteSalvo = service.create(new Cliente(
                request.getNome(),
                request.getEndereco(),
                request.getCpf()
            ));
            return ResponseEntity.accepted().body(ClienteConverter.converter(clienteSalvo));
        } catch (ClienteExistenteException e) {
            return ResponseEntity.badRequest().body(e.getMessage() + " - " + e.getCpf());
        }
    }
}
