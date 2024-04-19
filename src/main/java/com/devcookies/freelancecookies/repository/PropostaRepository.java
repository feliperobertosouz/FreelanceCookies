package com.devcookies.freelancecookies.repository;

import com.devcookies.freelancecookies.entitys.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Integer> {
}

