package com.devcookies.freelancecookies.repository;

import com.devcookies.freelancecookies.entitys.Usuario;

import java.util.List;

public interface InterRepository {
    List<Usuario> findAll();
}
