package com.roderly.microbiomelabufu.pessoa.dto.response;

import com.roderly.microbiomelabufu.endereco.dto.response.EnderecoResponse;

import java.time.LocalDate;
import java.util.List;

public record PacienteCompletoResponse(
        Long id_paciente,
        String nome,
        String sobrenome,
        LocalDate data_nascimento,
        String telefone_1,
        String telefone_2,
        String email,
        String cpf,
        String naturalidade,
        String nome_pai,
        String nome_mae,
        String nome_conjuge,
        LocalDate data_ultimo_atendimento,
        Long num_visitas,
        String indicacao,
        String observacao,
        Long id_profissao,
        Long id_plano_saude,
        Long id_estado_civil,
        Long id_sexo,
        Long id_etnia,
        Long id_escolaridade,
        Long id_religiao,
        List<EnderecoResponse> endereco,
        String foto_perfil
) {}