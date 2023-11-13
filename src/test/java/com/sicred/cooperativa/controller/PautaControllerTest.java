package com.sicred.cooperativa.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.sicred.cooperativa.entities.PautaEntity;
import com.sicred.cooperativa.services.PautaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PautaControllerTest {

    private PautaService pautaService;
    private PautaController pautaController;

    @BeforeEach
    public void setup() {
        pautaService = mock(PautaService.class);
        pautaController = new PautaController(pautaService);
    }

    @Test
    public void testCadastrarPauta() {

        String descricao = "Descrição da pauta";
        PautaEntity novaPauta = new PautaEntity();
        novaPauta.setDescricaoPauta(descricao);

        ResponseEntity<?> response = pautaController.cadastrarPauta(descricao);

    }


}
