package com.sicred.cooperativa.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
public class PautaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pauta")
    private Long idPauta;

    @Column(name = "descricao_pauta")
    private String descricaoPauta;

    @Column(name = "status_pauta")
    private boolean statusPauta;

    @Column(name = "data_criacao_pauta")
    private Date dataCriacaoPauta;

    @Column(name = "data_abertura_pauta")
    private Date dataAberturaPauta;

    @Column(name = "duracao_pauta")
    private Long duracaoPauta;

    @Column(name = "data_fechamento_pauta")
    private Date dataFechamentoPauta;

    public Long getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(Long idPauta) {
        this.idPauta = idPauta;
    }

    public String getDescricaoPauta() {
        return descricaoPauta;
    }

    public void setDescricaoPauta(String descricaoPauta) {
        this.descricaoPauta = descricaoPauta;
    }

    public boolean isStatusPauta() {
        return statusPauta;
    }

    public void setStatusPauta(boolean statusPauta) {
        this.statusPauta = statusPauta;
    }

    public Date getDataCriacaoPauta() {
        return dataCriacaoPauta;
    }

    public void setDataCriacaoPauta(Date dataCriacaoPauta) {
        this.dataCriacaoPauta = dataCriacaoPauta;
    }

    public Date getDataAberturaPauta() {
        return dataAberturaPauta;
    }

    public void setDataAberturaPauta(Date dataAberturaPauta) {
        this.dataAberturaPauta = dataAberturaPauta;
    }

    public Long getDuracaoPauta() {
        return duracaoPauta;
    }

    public void setDuracaoPauta(Long duracaoPauta) {
        this.duracaoPauta = duracaoPauta;
    }

    public Date getDataFechamentoPauta() {
        return dataFechamentoPauta;
    }

    public void setDataFechamentoPauta(Date dataFechamentoPauta) {
        this.dataFechamentoPauta = dataFechamentoPauta;
    }
}
