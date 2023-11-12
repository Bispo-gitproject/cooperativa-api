package com.sicred.cooperativa.controller;

import com.sicred.cooperativa.entities.PautaEntity;
import com.sicred.cooperativa.services.PautaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pautas")
public class PautaController {

    private final PautaService pautaService;

    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarPauta (@RequestParam(name = "descricao", required = true) String descricao){
        try {
            PautaEntity novaPauta = new PautaEntity();
            novaPauta.setDescricaoPauta(descricao);
            pautaService.cadastrarPauta(novaPauta);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaPauta);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao cadastrar a pauta: " + e.getMessage());
        }
    }

    @PostMapping("/abrir-sessao")
    public ResponseEntity<String> abrirSessaoVotacao(@RequestParam(name = "pautaId", required = true) Long pautaId, @RequestParam(defaultValue = "60") Long duracaoMinutos) {
        return pautaService.abrirSessaoVotacao(pautaId, duracaoMinutos);
    }

    @GetMapping("/consulta-pauta")
    public ResponseEntity<Optional<PautaEntity>> getPautasById(@RequestParam(name = "pautaId", required = true) Long pautaId) {
        try {
            Optional<PautaEntity> pauta = pautaService.getPautasPorId(pautaId);

            if (pauta.isPresent()) {
                return ResponseEntity.ok(pauta);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}