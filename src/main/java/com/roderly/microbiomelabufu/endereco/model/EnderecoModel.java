package com.roderly.microbiomelabufu.endereco.model;

import com.roderly.microbiomelabufu.endereco.dto.EnderecoDTO;
import com.roderly.microbiomelabufu.pessoa.model.PessoaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "endereco")
@Entity(name = "Endereco")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_endereco;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String id_uf;

    private String cep;

    private String referencia;


    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private PessoaModel pessoa;


    public EnderecoModel(EnderecoDTO dados) {
        this.id_endereco = dados.id_endereco();
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.id_uf = dados.id_uf();
        this.cep = dados.cep();
        this.referencia = dados.referencia();
    }


    public void updateFromDto(EnderecoDTO dto) {
        this.logradouro = dto.logradouro();
        this.numero = dto.numero();
        this.complemento = dto.complemento();
        this.bairro = dto.bairro();
        this.cidade = dto.cidade();
        this.id_uf = dto.id_uf();
        this.cep = dto.cep();
        this.referencia = dto.referencia();
    }

}
