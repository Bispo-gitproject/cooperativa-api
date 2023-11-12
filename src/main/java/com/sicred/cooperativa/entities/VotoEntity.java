package com.sicred.cooperativa.entities;

import javax.persistence.*;

@Entity
@Table(name = "votos")
public class VotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voto")
    private Long idVoto;

    @Column(name = "id_associados")
    private Long idAssociados;

    @Column(name = "id_pauta")
    private Long idPauta;

    @Column(name = "computa_voto")
    private String computaVoto;

    public Long getIdVoto() {
        return idVoto;
    }

    public void setIdVoto(Long idVoto) {
        this.idVoto = idVoto;
    }

    public Long getIdAssociados() {
        return idAssociados;
    }

    public void setIdAssociados(Long idAssociados) {
        this.idAssociados = idAssociados;
    }

    public Long getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(Long idPauta) {
        this.idPauta = idPauta;
    }

    public String getComputaVoto() {
        return computaVoto;
    }

    public void setComputaVoto(String computaVoto) {
        this.computaVoto = computaVoto;
    }
}
