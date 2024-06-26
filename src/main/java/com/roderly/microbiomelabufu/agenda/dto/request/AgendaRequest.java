package com.roderly.microbiomelabufu.agenda.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record AgendaRequest(
        Long id_evento,
        LocalDate data_evento,
        LocalTime hora_inicio,
        LocalTime hora_fim,
        Boolean dia_inteiro,
        String url,
        String descricao,
        Boolean is_active,
        Long id_usuario,
        Long id_status_agenda,
        Long id_tipo_evento,
        Long id_paciente
) {
}
