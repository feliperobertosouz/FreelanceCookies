package com.devcookies.freelancecookies.repository;

import jakarta.persistence.Query;
import com.devcookies.freelancecookies.config.HibernateConfig;
import com.devcookies.freelancecookies.entitys.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryUsuario implements  InterRepository{

    private final SessionFactory sessionFactory;

    public RepositoryUsuario(){
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Usuario> findAll(){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        List<Usuario> usuarios = session.createQuery("FROM USUARIO", Usuario.class).getResultList();
        transaction.commit();
        return usuarios;
    }
}
