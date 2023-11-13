package com.sicred.cooperativa.controller;

import com.sicred.cooperativa.entities.AssociadosEntity;
import com.sicred.cooperativa.entities.EnderecoEntity;
import com.sicred.cooperativa.services.AssociadosService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/associados")
@ApiOperation("Exemplo de método com parâmetros")
public class AssociadosController {

    private final AssociadosService associadosService;

    public AssociadosController(AssociadosService associadosService) {
        this.associadosService = associadosService;
    }

    @PostMapping
    public ResponseEntity<?> cadastraAssociados (@RequestParam(name = "cpfAssociados", required = true) String cpfAssociados,
    @RequestParam(name = "cepAssociados", required = true) String cepAssociados,
    @RequestParam(name = "nomeAssociados", required = true) String nomeAssociados){
    try {

        AssociadosEntity novoAssociado = new AssociadosEntity();
        novoAssociado.setCpfAssociados(cpfAssociados);
        novoAssociado.setNomeAssociados(nomeAssociados);

        EnderecoEntity novoEndereco = new EnderecoEntity();
        novoEndereco.setCep(cepAssociados);

        associadosService.cadastrarAssociados(novoAssociado,novoEndereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAssociado);
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao cadastrar o associado: " + e.getMessage());
    }
    }
}
