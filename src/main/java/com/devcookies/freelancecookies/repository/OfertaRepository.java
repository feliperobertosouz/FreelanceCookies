package com.devcookies.freelancecookies.repository;

import com.devcookies.freelancecookies.entitys.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Integer> {

    List<Oferta> findByTitulo(String titulo);
}
