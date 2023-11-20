package com.example.demo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.AboutUss;
import com.example.demo.Contacts;
import com.example.demo.Products;
 
@Repository
public class Dao {
 
    @PersistenceContext
    private EntityManager entityManager;
 
    public List<Products> obtenerTodosLosProductos() {
        return entityManager.createQuery("SELECT p FROM Products p", Products.class).getResultList();
    }
    public List<AboutUss> obtenerAboutUs() {
        return entityManager.createQuery("SELECT p FROM About_us p", AboutUss.class).getResultList();
    }
    public List<Contacts> obtenerContact() {
        return entityManager.createQuery("SELECT p FROM Contact p", Contacts.class).getResultList();
    }
}
