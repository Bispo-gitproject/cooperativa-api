package com.sicred.cooperativa.controller;

import com.sicred.cooperativa.entities.AssociadosEntity;
import com.sicred.cooperativa.entities.PautaEntity;
import com.sicred.cooperativa.entities.VotoEntity;
import com.sicred.cooperativa.repositories.AssociadosRepository;
import com.sicred.cooperativa.repositories.PautaRepository;
import com.sicred.cooperativa.repositories.VotoRepository;
import com.sicred.cooperativa.services.PautaService;
import com.sicred.cooperativa.services.VotoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Date;

class VotoServiceTest {

    @Mock
    private VotoRepository votoRepository;

    @Mock
    private AssociadosRepository associadosRepository;

    @Mock
    private PautaRepository pautaRepository;

    @Mock
    private PautaService pautaService;

    @InjectMocks
    private VotoService votoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testReceberVoto() {
        Long pautaId = 1L;
        VotoEntity voto = new VotoEntity();
        voto.setIdAssociados(1L);
        voto.setIdPauta(pautaId);
        voto.setComputaVoto("S");

        AssociadosEntity associado = new AssociadosEntity();
        associado.setIdAssociados(1L);

        PautaEntity pauta = new PautaEntity();
        pauta.setIdPauta(pautaId);
        pauta.setStatusPauta(true);
        pauta.setDataAberturaPauta(new Date(System.currentTimeMillis() - 10000));
        pauta.setDataFechamentoPauta(new Date(System.currentTimeMillis() + 10000));

        ResponseEntity<String> result = votoService.receberVoto(pautaId, voto);

    }

    @Test
    void testContabilzaVotos() {

        Long pautaId = 1L;

        PautaEntity pauta = new PautaEntity();
        pauta.setIdPauta(pautaId);
        pauta.setDescricaoPauta("Descrição da Pauta");

        ResponseEntity<String> result = votoService.contabilzaVotos(pautaId);

        String expectedResponse = "Contagem de votos para a pauta 1:\n" +
                "Pauta: Descrição da Pauta\n" +
                "Total de 'S': 3\n" +
                "Total de 'N': 2\n";

    }

    private VotoEntity criarVoto(String computaVoto) {
        VotoEntity voto = new VotoEntity();
        voto.setComputaVoto(computaVoto);
        return voto;
    }
}

