package com.roderly.microbiomelabufu.paciente.mapper;

import com.roderly.microbiomelabufu.cadastros_gerais.escolaridade.model.Escolaridade;
import com.roderly.microbiomelabufu.cadastros_gerais.estado_civil.model.EstadoCivil;
import com.roderly.microbiomelabufu.cadastros_gerais.etnia.model.Etnia;
import com.roderly.microbiomelabufu.cadastros_gerais.plano_saude.model.PlanoSaude;
import com.roderly.microbiomelabufu.cadastros_gerais.profissao.model.Profissao;
import com.roderly.microbiomelabufu.cadastros_gerais.religiao.model.Religiao;
import com.roderly.microbiomelabufu.cadastros_gerais.sexo.model.Sexo;
import com.roderly.microbiomelabufu.common.Utilitarios.DateUtil;
import com.roderly.microbiomelabufu.consulta.dto.response.ConsultasPacienteBasicoResponse;
import com.roderly.microbiomelabufu.consulta.model.Consulta;
import com.roderly.microbiomelabufu.paciente.dto.request.PacienteRequest;
import com.roderly.microbiomelabufu.paciente.dto.response.PacienteFormularioResponse;
import com.roderly.microbiomelabufu.paciente.dto.response.PacienteInfoBasicaResponse;
import com.roderly.microbiomelabufu.paciente.dto.response.PacienteResponse;
import com.roderly.microbiomelabufu.paciente.dto.response.PacienteListagemResponse;
import com.roderly.microbiomelabufu.paciente.model.Paciente;
import jakarta.persistence.Tuple;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

public class PacienteMapper {
    public static Paciente PacienteRequestToPaciente(PacienteRequest request) {
        Paciente paciente = new Paciente();
        Profissao profissao = request.id_profissao() != null ? new Profissao(request.id_profissao()) : null;
        PlanoSaude planoSaude = request.id_plano_saude() != null ? new PlanoSaude(request.id_plano_saude()) : null;
        EstadoCivil estadoCivil = request.id_estado_civil() != null ? new EstadoCivil(request.id_estado_civil()) : null;
        Sexo sexo = request.id_sexo() != null ? new Sexo(request.id_sexo()) : null;
        Etnia etnia = request.id_etnia() != null ? new Etnia(request.id_etnia()) : null;
        Escolaridade escolaridade = request.id_escolaridade() != null ? new Escolaridade(request.id_escolaridade()) : null;
        Religiao religiao = request.id_religiao() != null ? new Religiao(request.id_religiao()) : null;

        paciente.setId_paciente(request.id_paciente());
        paciente.setNome(request.nome());
        paciente.setSobrenome(request.sobrenome());
        paciente.setData_nascimento(request.data_nascimento());
        paciente.setTelefone_1(request.telefone_1());
        paciente.setTelefone_2(request.telefone_2());
        paciente.setEmail(request.email());
        paciente.setCpf(request.cpf());
        paciente.setNaturalidade(request.naturalidade());
        paciente.setNome_pai(request.nome_pai());
        paciente.setNome_mae(request.nome_mae());
        paciente.setNome_conjuge(request.nome_conjuge());
        paciente.setNumero_plano_saude(request.numero_plano_saude());
        paciente.setNum_visitas(request.num_visitas());
        paciente.setIndicacao(request.indicacao());
        paciente.setObservacao(request.observacao());
        paciente.setProfissao(profissao);
        paciente.setPlanoSaude(planoSaude);
        paciente.setEstadoCivil(estadoCivil);
        paciente.setSexo(sexo);
        paciente.setEtnia(etnia);
        paciente.setReligiao(religiao);
        paciente.setEscolaridade(escolaridade);

        return paciente;
    }


    public static PacienteResponse pacienteToPacienteResponse(Paciente responsePaciente) {

        return new PacienteResponse(
                responsePaciente.getId_paciente(),
                responsePaciente.getNome(),
                responsePaciente.getSobrenome(),
                responsePaciente.getData_nascimento(),
                responsePaciente.getTelefone_1(),
                responsePaciente.getTelefone_2(),
                responsePaciente.getEmail(),
                responsePaciente.getCpf(),
                responsePaciente.getNaturalidade(),
                responsePaciente.getNome_pai(),
                responsePaciente.getNome_mae(),
                responsePaciente.getNome_conjuge(),
                responsePaciente.getNumero_plano_saude(),
                responsePaciente.getNum_visitas(),
                responsePaciente.getIndicacao(),
                responsePaciente.getObservacao(),
                responsePaciente.getProfissao() != null ? responsePaciente.getProfissao().getId_profissao() : null,
                responsePaciente.getPlanoSaude() != null ? responsePaciente.getPlanoSaude().getId_plano_saude() : null,
                responsePaciente.getEstadoCivil() != null ? responsePaciente.getEstadoCivil().getId_estado_civil() : null,
                responsePaciente.getSexo() != null ? responsePaciente.getSexo().getId_sexo() : null,
                responsePaciente.getEtnia() != null ? responsePaciente.getEtnia().getId_etnia() : null,
                responsePaciente.getEscolaridade() != null ? responsePaciente.getEscolaridade().getId_escolaridade() : null,
                responsePaciente.getReligiao() != null ? responsePaciente.getReligiao().getId_religiao() : null
        );
    }


    public static PacienteListagemResponse pacienteToPacienteListagemResponse(Paciente paciente) {
        LocalDate dataNascimento = paciente.getData_nascimento();
        Integer idade = (dataNascimento != null) ? Period.between(dataNascimento, LocalDate.now()).getYears() : null;

        var consultasPaciente = paciente.getConsultas().stream()
                .map(PacienteMapper::pacienteConsultasToConsultasPacienteBasicoResponse)
                .toList();

        return new PacienteListagemResponse(
                paciente.getId_paciente(),
                paciente.getNome() + " " + paciente.getSobrenome(),
                idade,
                paciente.getTelefone_1(),
                paciente.getTelefone_2(),
                paciente.getFotoPerfil() != null ? paciente.getFotoPerfil().getCaminho_arquivo() + "/" + paciente.getFotoPerfil().getId_foto_perfil() + ".jpeg" : null,
                paciente.getPlanoSaude() != null ? paciente.getPlanoSaude().getDescricao() : null,
                paciente.getEndereco() != null ? paciente.getEndereco().getCidade() : null,
                consultasPaciente
        );
    }


    public static ConsultasPacienteBasicoResponse pacienteConsultasToConsultasPacienteBasicoResponse(Consulta consulta) {
        String tipo_consulta = consulta.getId_tipo_consulta() == 1 ? "Consulta" : "Retorno";

        return new ConsultasPacienteBasicoResponse(
                consulta.getId_consulta(),
                DateUtil.LocalDateTimeToDateBR(consulta.getData_hora()),
                tipo_consulta
        );
    }


    public  static PacienteInfoBasicaResponse pacienteToPacienteInfoBasicaResponse(Paciente paciente){
        LocalDate dataNascimento = paciente.getData_nascimento();
        Integer idade = (dataNascimento != null) ? Period.between(dataNascimento, LocalDate.now()).getYears() : null;

        return new PacienteInfoBasicaResponse(
                paciente.getId_paciente(),
                paciente.getFotoPerfil() != null ? paciente.getFotoPerfil().getCaminho_arquivo() + "/" + paciente.getFotoPerfil().getId_foto_perfil() + ".jpeg" : null,
                paciente.getNome() + " " + paciente.getSobrenome(),
                idade,
                paciente.getPlanoSaude() != null ? paciente.getPlanoSaude().getDescricao() : null,
                paciente.getTelefone_1(),
                paciente.getTelefone_2()
        );
    }

}
