package com.devcookies.freelancecookies.repository;
import com.devcookies.freelancecookies.entitys.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

}
