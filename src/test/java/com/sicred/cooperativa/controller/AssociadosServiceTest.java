package com.sicred.cooperativa.controller;

import com.sicred.cooperativa.entities.AssociadosEntity;
import com.sicred.cooperativa.entities.EnderecoEntity;
import com.sicred.cooperativa.repositories.AssociadosRepository;
import com.sicred.cooperativa.services.AssociadosService;
import com.sicred.cooperativa.services.ViaCEPService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class AssociadosServiceTest {

    @Mock
    private AssociadosRepository associadosRepository;

    @Mock
    private ViaCEPService viaCEPService;

    @InjectMocks
    private AssociadosService associadosService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCadastrarAssociados() {
        // Configuração de dados de teste
        AssociadosEntity novoAssociado = new AssociadosEntity();
        novoAssociado.setCpfAssociados("12345678901");
        novoAssociado.setNomeAssociados("John Doe");

        EnderecoEntity novoEndereco = new EnderecoEntity();
        novoEndereco.setCep("06036060");

        EnderecoEntity enderecoMock = new EnderecoEntity();
        enderecoMock.setIdEndereco(1L);
        enderecoMock.setCep("06036060");
        enderecoMock.setBairro("Bairro");
        enderecoMock.setLocalidade("Localidade");
        enderecoMock.setLogradouro("Logradouro");
        enderecoMock.setUf("UF");

        AssociadosEntity result = associadosService.cadastrarAssociados(novoAssociado, novoEndereco);

    }
}
