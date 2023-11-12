package com.sicred.cooperativa.repositories;

import com.sicred.cooperativa.entities.PautaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<PautaEntity, Long> {
}