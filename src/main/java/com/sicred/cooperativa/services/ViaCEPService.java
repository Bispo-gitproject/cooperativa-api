package com.sicred.cooperativa.services;

import com.sicred.cooperativa.entities.ViaCEPResponse;
import com.sicred.cooperativa.entities.EnderecoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCEPService {

    private final RestTemplate restTemplate;

    @Value("${viacep.url}")
    private String viaCEPUrl;

    @Autowired
    public ViaCEPService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EnderecoEntity consultarCEP(String cep) {
        String url = String.format("%s/%s/json", viaCEPUrl, cep);
        ViaCEPResponse viaCEPResponse = restTemplate.getForObject(url, ViaCEPResponse.class);

        EnderecoEntity enderecoEntity = new EnderecoEntity();
        enderecoEntity.setCep(viaCEPResponse.getCep());
        enderecoEntity.setLogradouro(viaCEPResponse.getLogradouro());
        enderecoEntity.setBairro(viaCEPResponse.getBairro());
        enderecoEntity.setLocalidade(viaCEPResponse.getLocalidade());
        enderecoEntity.setUf(viaCEPResponse.getUf());
        enderecoEntity.setNumResidencia("");

        return enderecoEntity;
    }
}
