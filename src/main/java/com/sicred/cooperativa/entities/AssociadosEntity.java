package com.sicred.cooperativa.entities;

import org.checkerframework.common.aliasing.qual.Unique;

import javax.persistence.*;

@Entity
@Table(name = "associados")
public class AssociadosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_associados")
    private Long idAssociados;

    @Column(name = "nome_associados")
    private String nomeAssociados;

    @Column(name = "cpf_associados")
    @Unique
    private String cpfAssociados;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id_endereco")
    private EnderecoEntity endereco;

    public Long getIdAssociados() {
        return idAssociados;
    }

    public void setIdAssociados(Long idAssociados) {
        this.idAssociados = idAssociados;
    }

    public String getNomeAssociados() {
        return nomeAssociados;
    }

    public void setNomeAssociados(String nomeAssociados) {
        this.nomeAssociados = nomeAssociados;
    }

    public String getCpfAssociados() {
        return cpfAssociados;
    }

    public void setCpfAssociados(String cpfAssociados) {
        this.cpfAssociados = cpfAssociados;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }
}
