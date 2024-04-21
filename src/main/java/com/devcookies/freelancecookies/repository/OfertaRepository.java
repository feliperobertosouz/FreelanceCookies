package com.devcookies.freelancecookies.repository;

import com.devcookies.freelancecookies.entitys.Oferta;
import com.devcookies.freelancecookies.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OfertaRepository extends JpaRepository<Oferta, Integer> {
    @Query("SELECT u FROM Oferta u WHERE u.Id = :id")
    Oferta findOfertaById(@Param("id") int id);
}
