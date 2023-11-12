package com.sicred.cooperativa.repositories;

import com.sicred.cooperativa.entities.VotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VotoRepository extends JpaRepository<VotoEntity, Long>{

    Optional<VotoEntity> findByIdPautaAndIdAssociados(Long idPauta, Long idAssociado);

    List<VotoEntity> findByIdPauta(Long pautaId);
}