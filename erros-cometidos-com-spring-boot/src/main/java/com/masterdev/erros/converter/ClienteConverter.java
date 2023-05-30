package com.masterdev.erros.converter;

import com.masterdev.erros.cliente.Cliente;
import com.masterdev.erros.correto.ClienteResponseDTO;

public class ClienteConverter {

    public static ClienteResponseDTO converter(Cliente originalCliente) {
        return new ClienteResponseDTO(
            originalCliente.getId(),
            originalCliente.getNome(),
            originalCliente.getEndereco()
        );
    }

}
