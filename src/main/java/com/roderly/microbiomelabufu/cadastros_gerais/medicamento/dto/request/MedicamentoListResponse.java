package com.roderly.microbiomelabufu.cadastros_gerais.medicamento.dto.request;

public record MedicamentoListResponse(
        Long  id_medicamento,
        String nome,
        String dosagem,
        String fabricante,
        String instrucoes,
        Boolean is_active

) {
}
