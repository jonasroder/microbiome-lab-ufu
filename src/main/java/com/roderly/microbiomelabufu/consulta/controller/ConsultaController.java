package com.roderly.microbiomelabufu.consulta.controller;

import com.roderly.microbiomelabufu.cadastros_gerais.medicamento.repository.MedicamentoRepository;
import com.roderly.microbiomelabufu.common.dto.ApiResponseDTO;
import com.roderly.microbiomelabufu.consulta.dto.request.ConsultaCompletoRequest;
import com.roderly.microbiomelabufu.consulta.dto.request.ConsultaDiagnosticoRequest;
import com.roderly.microbiomelabufu.consulta.dto.request.PacienteMedicamentoRequest;
import com.roderly.microbiomelabufu.consulta.dto.request.PacienteSuplementoRequest;
import com.roderly.microbiomelabufu.consulta.dto.response.ConsultaCompletoResponse;
import com.roderly.microbiomelabufu.consulta.mapper.ConsultaMapper;
import com.roderly.microbiomelabufu.consulta.model.Consulta;
import com.roderly.microbiomelabufu.consulta.model.ConsultaDiagnostico;
import com.roderly.microbiomelabufu.consulta.model.PacienteMedicamento;
import com.roderly.microbiomelabufu.consulta.model.PacienteSuplemento;
import com.roderly.microbiomelabufu.consulta.repository.ConsultaDiagnosticoRepository;
import com.roderly.microbiomelabufu.consulta.repository.ConsultaRepository;
import com.roderly.microbiomelabufu.consulta.repository.PacienteMedicamentoRepository;
import com.roderly.microbiomelabufu.cadastros_gerais.diagnostico.repository.DiagnosticoRepository;
import com.roderly.microbiomelabufu.consulta.repository.PacienteSuplementoRepository;
import com.roderly.microbiomelabufu.paciente.model.Paciente;
import com.roderly.microbiomelabufu.paciente.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Transactional
@RequestMapping("/api/consulta")
public class ConsultaController {

    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    ConsultaRepository consultaRepository;
    @Autowired
    DiagnosticoRepository diagnosticoRepository;
    @Autowired
    ConsultaDiagnosticoRepository consultaDiagnosticoRepository;
    @Autowired
    MedicamentoRepository medicamentoRepository;
    @Autowired
    PacienteMedicamentoRepository pacienteMedicamentoRepository;
    @Autowired
    PacienteSuplementoRepository pacienteSuplementoRepository;


    @GetMapping("/load/{id_paciente}/{id_consulta}")
    public ResponseEntity<ConsultaCompletoResponse> getDadosConsulta(@PathVariable Long id_paciente, Long id_consulta) {

        Tuple tuple = pacienteRepository.findPessoaWithImageProfile(id_paciente)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrada com ID: " + id_paciente));

        Paciente paciente = tuple.get(0, Paciente.class);
        String caminhoFotoPerfil = tuple.get(1, String.class);
        String planoDeSaude = tuple.get(2, String.class);

        ConsultaCompletoResponse response = ConsultaMapper.consultaToConsultaCompletoResponse(paciente, caminhoFotoPerfil, planoDeSaude);

        return ResponseEntity.ok(response);
    }


    @PostMapping("/insert")
    public ResponseEntity<ApiResponseDTO> insert(@RequestBody @Valid ConsultaCompletoRequest request) throws IOException {

        Consulta consulta = ConsultaMapper.conusltaCompletoRequestToConsulta(request);
        Consulta consultaSalva = consultaRepository.save(consulta);


        for(ConsultaDiagnosticoRequest consultaDiagnosticoRequest : request.arrConsultaDiagnostico()){
            ConsultaDiagnostico consultaDiagnostico =  ConsultaMapper.conusltaCompletoRequestToConsultaDiagnostico(consulta, consultaDiagnosticoRequest);
            consultaDiagnosticoRepository.save(consultaDiagnostico);
        }


        for(PacienteMedicamentoRequest pacienteMedicamentoRequest : request.arrMedicamentoUsoPaciente()){
            PacienteMedicamento pacienteMedicamento = ConsultaMapper.conusltaCompletoRequestToPacienteMedicamento(consulta, pacienteMedicamentoRequest);
            pacienteMedicamentoRepository.save(pacienteMedicamento);
        }


        for(PacienteSuplementoRequest pacienteSuplementoRequest : request.arrSuplementoUsoPaciente()){
            PacienteSuplemento pacienteSuplemento = ConsultaMapper.conusltaCompletoRequestToPacienteSuplemento(consulta, pacienteSuplementoRequest);
            pacienteSuplementoRepository.save(pacienteSuplemento);
        }


        return ResponseEntity.ok(new ApiResponseDTO( (long) 1 ,"Consulta cadastrado com sucesso."));
    }

}
