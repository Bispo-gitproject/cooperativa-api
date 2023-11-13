package com.sicred.cooperativa.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.sicred.cooperativa.entities.AssociadosEntity;
import com.sicred.cooperativa.entities.EnderecoEntity;
import com.sicred.cooperativa.repositories.AssociadosRepository;
import com.sicred.cooperativa.services.AssociadosService;
import com.sicred.cooperativa.services.ViaCEPService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AssociadosServiceTest {

    private AssociadosRepository associadosRepository;
    private ViaCEPService     viaCEPService;
    private AssociadosService associadosService;

    @BeforeEach
    public void setup() {
        associadosRepository = mock(AssociadosRepository.class);
        viaCEPService = mock(ViaCEPService.class);
        associadosService = new AssociadosService(associadosRepository, viaCEPService);
    }

    @Test
    public void testCadastrarAssociados() {

        AssociadosEntity novoAssociado = new AssociadosEntity();
        novoAssociado.setCpfAssociados("12345678901");
        novoAssociado.setNomeAssociados("Henrique Bispo");

        EnderecoEntity novoEndereco = new EnderecoEntity();
        novoEndereco.setCep("06036060");

        AssociadosEntity result = associadosService.cadastrarAssociados(novoAssociado, novoEndereco);

    }
}
