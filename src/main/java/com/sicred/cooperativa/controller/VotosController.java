package com.sicred.cooperativa.controller;

import com.sicred.cooperativa.entities.VotoEntity;
import com.sicred.cooperativa.services.VotoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votos")
public class VotosController {

    private VotoService votoService;

    @PostMapping("/receber-voto/{pautaId}")
    public ResponseEntity<String> receberVoto(@PathVariable Long pautaId, @RequestBody VotoEntity voto){
        return votoService.receberVoto(pautaId, voto);
    }

    @GetMapping("/contabiliza-votos")
    public ResponseEntity<String> abrirSessaoVotacao(@RequestParam(name = "pautaId", required = true) Long pautaId) {
        return votoService.contabilzaVotos(pautaId);
    }
}