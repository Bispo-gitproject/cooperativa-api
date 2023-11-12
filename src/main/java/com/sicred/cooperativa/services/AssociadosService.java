package com.sicred.cooperativa.services;

import com.sicred.cooperativa.entities.AssociadosEntity;
import com.sicred.cooperativa.entities.EnderecoEntity;
import com.sicred.cooperativa.repositories.AssociadosRepository;
import org.springframework.stereotype.Service;

@Service
public class AssociadosService {

    private final AssociadosRepository associadosRepository;
    private final ViaCEPService viaCEPService;

    public AssociadosService(AssociadosRepository associadosRepository, ViaCEPService viaCEPService) {
        this.associadosRepository = associadosRepository;
        this.viaCEPService = viaCEPService;
    }

    public AssociadosEntity cadastrarAssociados(AssociadosEntity novoAssociados, EnderecoEntity novoEndereco) {
        EnderecoEntity endereco = viaCEPService.consultarCEP(novoEndereco.getCep());

        novoEndereco.setIdEndereco(endereco.getIdEndereco());
        novoEndereco.setCep(endereco.getCep());
        novoEndereco.setBairro(endereco.getBairro());
        novoEndereco.setLocalidade(endereco.getLocalidade());
        novoEndereco.setLogradouro(endereco.getLogradouro());
        novoEndereco.setUf(endereco.getUf());

        novoAssociados.setEndereco(novoEndereco);
        return associadosRepository.save(novoAssociados);

    }
}
