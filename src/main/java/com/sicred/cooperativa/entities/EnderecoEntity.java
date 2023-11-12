package com.sicred.cooperativa.entities;

import javax.persistence.*;

@Entity
@Table(name = "enderecos")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long   idEndereco;
    @Column(name = "cep_residencia")
    private String cep;
    @Column(name = "log_residencia")
    private String logradouro;
    @Column(name = "bairro_residencia")
    private String bairro;
    @Column(name = "cidade_residencia")
    private String localidade;
    @Column(name = "uf_residencia")
    private String uf;
    @Column(name = "num_residencia")
    private String numResidencia;

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNumResidencia() {
        return numResidencia;
    }

    public void setNumResidencia(String numResidencia) {
        this.numResidencia = numResidencia;
    }
}