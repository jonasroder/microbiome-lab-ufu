package com.roderly.microbiomelabufu.consulta.model;


import com.roderly.microbiomelabufu.cadastros_gerais.frequencia.model.Frequencia;
import com.roderly.microbiomelabufu.cadastros_gerais.medicamento.model.Medicamento;
import com.roderly.microbiomelabufu.cadastros_gerais.periodo.model.Periodo;
import com.roderly.microbiomelabufu.cadastros_gerais.suplemento.model.Suplemento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "prescricao_suplemento")
@Entity(name = "PrescricaoSuplemento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrescricaoSuplemento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prescricao_suplemento;
    private String dosagem;
    private String instrucoes;
    private Boolean is_active;

    @ManyToOne
    @JoinColumn(name = "id_consulta", referencedColumnName = "id_consulta")
    private Consulta consulta;

    @ManyToOne
    @JoinColumn(name = "id_suplemento", referencedColumnName = "id_suplemento")
    private Suplemento suplemento;

    @ManyToOne
    @JoinColumn(name = "id_frequencia", referencedColumnName = "id_frequencia")
    private Frequencia frequencia;

    @ManyToOne
    @JoinColumn(name = "id_periodo", referencedColumnName = "id_periodo")
    private Periodo periodo;


}
