package com.roderly.microbiomelabufu.consulta.model;


import com.roderly.microbiomelabufu.cadastros_gerais.frequencia.model.Frequencia;
import com.roderly.microbiomelabufu.cadastros_gerais.medicamento.model.Medicamento;
import com.roderly.microbiomelabufu.cadastros_gerais.periodo.model.Periodo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name = "paciente_medicamento")
@Entity(name = "PacienteMedicamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteMedicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paciente_medicamento;
    private String dosagem;
    private Boolean is_active;

    @ManyToOne
    @JoinColumn(name = "id_consulta", referencedColumnName = "id_consulta")
    private Consulta consulta;

    @ManyToOne
    @JoinColumn(name = "id_medicamento", referencedColumnName = "id_medicamento")
    private Medicamento medicamento;

    @ManyToOne
    @JoinColumn(name = "id_frequencia", referencedColumnName = "id_frequencia")
    private Frequencia frequencia;

    @ManyToOne
    @JoinColumn(name = "id_periodo", referencedColumnName = "id_periodo")
    private Periodo periodo;


}
