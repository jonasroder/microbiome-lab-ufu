package com.roderly.microbiomelabufu.paciente.dto.response;

import java.time.LocalDate;

public record PacienteListagemResponse(
        Long id_paciente,
        String nome,
        Integer idade,
        String telefone_1,
        String telefone_2,
        LocalDate data_ultimo_atendimento,
        Long num_visitas,
        String foto_perfil
) {}