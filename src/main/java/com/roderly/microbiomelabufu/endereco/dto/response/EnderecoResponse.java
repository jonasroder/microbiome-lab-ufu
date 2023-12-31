package com.roderly.microbiomelabufu.endereco.dto.response;

public record EnderecoResponse(
        Long id_endereco,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        Long id_uf,
        String cep,
        String referencia
){}
