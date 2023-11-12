package com.sicred.cooperativa.repositories;

import com.sicred.cooperativa.entities.AssociadosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadosRepository extends JpaRepository<AssociadosEntity, Long> {
}
