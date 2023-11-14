package com.sicred.cooperativa.services;

import com.sicred.cooperativa.entities.AssociadosEntity;
import com.sicred.cooperativa.entities.PautaEntity;
import com.sicred.cooperativa.entities.VotoEntity;
import com.sicred.cooperativa.repositories.AssociadosRepository;
import com.sicred.cooperativa.repositories.PautaRepository;
import com.sicred.cooperativa.repositories.VotoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VotoService{

    private VotoRepository votoRepository;
    private AssociadosRepository associadosRepository;
    private PautaRepository pautaRepository;
    private PautaService pautaService;

    public VotoService(VotoRepository votoRepository, AssociadosRepository associadosRepository, PautaRepository pautaRepository, PautaService pautaService) {
        this.votoRepository = votoRepository;
        this.associadosRepository = associadosRepository;
        this.pautaRepository = pautaRepository;
        this.pautaService = pautaService;
    }

    public ResponseEntity<String> receberVoto(Long idPauta, VotoEntity votoComputado) {

        validarIdAssociado(votoComputado.getIdAssociados());
        validarIdPauta(votoComputado.getIdPauta());
        validarOpcaoVoto(votoComputado.getComputaVoto());
        Date dataAtual = Date.from(Instant.now());

        Optional<AssociadosEntity> associadoOptional = associadosRepository.findById(votoComputado.getIdAssociados());
        if (associadoOptional.isPresent()) {
            Optional<PautaEntity> pauta = pautaRepository.findById(votoComputado.getIdPauta());
            if (pauta.isPresent()) {
                if (pauta.get().isStatusPauta() == false){
                    return ResponseEntity.ok("Sessão ainda não está ativa");
                }
                if (dataAtual.after(pauta.get().getDataAberturaPauta()) && dataAtual.before(pauta.get().getDataFechamentoPauta())){
                    Optional<VotoEntity> voto = votoRepository.findByIdPautaAndIdAssociados(votoComputado.getIdPauta(),votoComputado.getIdAssociados());
                    if (voto.isPresent()){
                        return ResponseEntity.ok("Voto já computado");
                    }else {
                        votoRepository.save(votoComputado);
                        return ResponseEntity.ok("Voto computado com sucesso");
                    }
                }else {
                    return ResponseEntity.ok("Votação encerrada as : " + pauta.get().getDataFechamentoPauta());
                }

            }else {
                return ResponseEntity.badRequest().body("Pauta inexistente, selecione uma pauta valida.");
            }
        }else {
            return ResponseEntity.badRequest().body("Identificação não associada.");
        }
    }

    private void validarIdAssociado(Long idAssociados) {
        if (idAssociados == null) {
            throw new IllegalArgumentException("CPF do associado não pode ser vazio.");
        }
    }

    private void validarIdPauta(Long idPauta) {
        if (idPauta == null) {
            throw new IllegalArgumentException("Identificação da Pauta de votação não pode ser vazia.");
        }
    }

    private void validarOpcaoVoto(String computaVoto) {
        if (computaVoto.isEmpty()) {
            throw new IllegalArgumentException("Opção de voto não pode ser vazia.");
        } else if (!computaVoto.equalsIgnoreCase("S") && !computaVoto.equalsIgnoreCase("N")) {
            throw new IllegalArgumentException("Opção de votos válidas são \"S\" - sim ou \"N\" - Não.");
        }
    }
    public ResponseEntity<String> contabilzaVotos(Long pautaId) {

        long totalVotosS = 0;
        long totalVotosN = 0;
        String descricao = "";

        validarIdPauta(pautaId);

        List<VotoEntity> votos = votoRepository.findByIdPauta(pautaId);

        if (votos.isEmpty()) {
            return ResponseEntity.badRequest().body("Não foram encontrados votos para a pauta com ID " + pautaId);
        }else{
            Optional<PautaEntity> pauta = pautaService.getPautasPorId(pautaId);
            descricao = pauta.get().getDescricaoPauta();
        }

        for (VotoEntity voto : votos) {
            String computaVoto = voto.getComputaVoto();
            if ("S".equalsIgnoreCase(computaVoto)) {
                totalVotosS++;
            } else if ("N".equalsIgnoreCase(computaVoto)) {
                totalVotosN++;
            }
        }
        StringBuilder resposta = new StringBuilder();
        resposta.append("Contagem de votos para a pauta ").append(pautaId).append(":\n");
        resposta.append("Pauta: ").append(descricao).append("\n");
        resposta.append("Total de 'S': ").append(totalVotosS).append("\n");
        resposta.append("Total de 'N': ").append(totalVotosN).append("\n");

        return ResponseEntity.ok(resposta.toString());
    }

}