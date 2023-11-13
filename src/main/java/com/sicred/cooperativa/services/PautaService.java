package com.sicred.cooperativa.services;

import com.sicred.cooperativa.entities.PautaEntity;
import com.sicred.cooperativa.repositories.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.time.*;
import java.util.Optional;

@Service
public class PautaService {

    private final PautaRepository pautaRepository;

    @Autowired
    public PautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    public PautaEntity cadastrarPauta(PautaEntity pauta) {

        pauta.setDataCriacaoPauta(Date.from(Instant.now()));

        pauta.setStatusPauta(false);
        return pautaRepository.save(pauta);
    }

    public ResponseEntity<String> abrirSessaoVotacao(Long idPauta, Long duracao) {
        Optional<PautaEntity> optionalPauta = pautaRepository.findById(idPauta);

        if (optionalPauta.isPresent()) {
            PautaEntity pauta = optionalPauta.get();

            if (pauta.getDataAberturaPauta() == null) {

                pauta.setDataAberturaPauta(Date.from(Instant.now()));
                pauta.setStatusPauta(true);
                pauta.setDuracaoPauta(duracao);

                long minutos = duracao;
                Duration duration = Duration.ofMinutes(minutos);

                LocalDateTime dataFechamento = LocalDateTime.now().plus(duration);
                pauta.setDataFechamentoPauta(java.sql.Timestamp.valueOf(dataFechamento));

                pautaRepository.save(pauta);
                return ResponseEntity.ok("Sessão de votação aberta com sucesso.");
            } else {
                return ResponseEntity.badRequest().body("A pauta já está aberta.");
            }
        } else {
            return ResponseEntity.badRequest().body("Pauta não encontrada.");
        }
    }


    public Optional<PautaEntity> getPautasPorId(Long pautasId) {
        return pautaRepository.findById(pautasId);
    }

}