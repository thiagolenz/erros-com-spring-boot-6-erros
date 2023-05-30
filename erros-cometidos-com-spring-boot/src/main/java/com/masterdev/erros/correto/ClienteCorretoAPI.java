package com.masterdev.erros.correto;

import com.masterdev.erros.cliente.Cliente;
import com.masterdev.erros.converter.ClienteConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/correto/cliente")
@RestController
public class ClienteCorretoAPI {
    @Autowired
    private ClienteService service;

    @GetMapping("/{id}")
    public ClienteResponseDTO getById(@PathVariable("id") Long id) {
        Cliente originalCliente = service.getById(id);
        return ClienteConverter.converter(originalCliente);
    }

    @PostMapping
    public ClienteResponseDTO salvar(@RequestBody ClienteRequestDTO requestDTO) {
        Cliente clienteSalvo = service.salvar(new Cliente(
            requestDTO.getNome(),
            requestDTO.getEndereco(),
            requestDTO.getCpf()
        ));

        return ClienteConverter.converter(clienteSalvo);
    }
}
