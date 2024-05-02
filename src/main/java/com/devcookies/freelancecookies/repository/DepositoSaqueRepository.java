package com.devcookies.freelancecookies.repository;

import com.devcookies.freelancecookies.entitys.DepositoSaque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepositoSaqueRepository extends JpaRepository<DepositoSaque, Integer> {

    @Query("SELECT d FROM DepositoSaque d WHERE d.Usuario.Id = :id")
    public List<DepositoSaque> findDepositosByUsuario(@Param("id") int id);

}
