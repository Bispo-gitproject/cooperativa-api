package com.sicred.cooperativa.controller;

import com.sicred.cooperativa.entities.PautaEntity;
import com.sicred.cooperativa.repositories.PautaRepository;
import com.sicred.cooperativa.services.PautaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

class PautaServiceTest {

    @Mock
    private PautaRepository pautaRepository;

    @InjectMocks
    private PautaService pautaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCadastrarPauta() {
        PautaEntity pauta = new PautaEntity();
        pauta.setDescricaoPauta("Descrição da Pauta");

        PautaEntity result = pautaService.cadastrarPauta(pauta);

    }

    @Test
    void testAbrirSessaoVotacao() {
        Long idPauta = 1L;
        Long duracao = 30L; // 30 minutos

        PautaEntity pauta = new PautaEntity();
        pauta.setIdPauta(idPauta);

        ResponseEntity<String> result = pautaService.abrirSessaoVotacao(idPauta, duracao);

    }

    @Test
    void testAbrirSessaoVotacaoPautaJaAberta() {
        Long idPauta = 1L;
        Long duracao = 30L;

        PautaEntity pauta = new PautaEntity();
        pauta.setDataAberturaPauta(Timestamp.from(Instant.now()));

        ResponseEntity<String> result = pautaService.abrirSessaoVotacao(idPauta, duracao);

    }

    @Test
    void testAbrirSessaoVotacaoPautaNaoEncontrada() {
        Long idPauta = 1L;
        Long duracao = 30L;

        ResponseEntity<String> result = pautaService.abrirSessaoVotacao(idPauta, duracao);

    }

    @Test
    void testGetPautasPorId() {
        Long idPauta = 1L;

        PautaEntity pauta = new PautaEntity();
        pauta.setIdPauta(idPauta);

        Optional<PautaEntity> result = pautaService.getPautasPorId(idPauta);

    }
}
