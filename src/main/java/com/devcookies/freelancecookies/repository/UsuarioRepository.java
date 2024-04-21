package com.devcookies.freelancecookies.repository;

import com.devcookies.freelancecookies.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u")
    List<Usuario> findAllUsuarios();

    @Query("SELECT u FROM Usuario u WHERE u.Id = :id")
    Usuario findUsuarioById(@Param("id") int id);



}
