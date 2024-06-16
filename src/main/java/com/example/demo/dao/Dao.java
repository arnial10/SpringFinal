package com.example.demo.dao;
 
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import com.example.demo.AboutUss;
import com.example.demo.Contacts;
import com.example.demo.Products;
import com.example.demo.Users;
@Repository
public class Dao {
    @PersistenceContext
    private EntityManager entityManager;
    public List<Products> obtenerTodosLosProductos() {
        return entityManager.createQuery("SELECT p FROM Products p", Products.class).getResultList();
    }
    public List<Users> obtenerTodosLosUsers() {
        return entityManager.createQuery("SELECT u FROM Users u", Users.class).getResultList();
    }
    public List<AboutUss> obtenerAboutUs() {
        return entityManager.createQuery("SELECT p FROM About_us p", AboutUss.class).getResultList();
    }
    public List<Contacts> obtenerContact() {
        return entityManager.createQuery("SELECT p FROM Contact p", Contacts.class).getResultList();
    }
    public void agregarProducto(Products producto) {
        entityManager.persist(producto);
    }
    public List<Products> encontrarProducto(Long id) {
    	return entityManager.createQuery("SELECT p FROM Products p WHERE id_Products = " + id, Products.class).getResultList();
    }
    
    @Transactional
    public void addUsers(Users users) {
        entityManager.persist(users);
    }
    
    @Transactional
    public void insertarProducto(Products producto) {
        entityManager.persist(producto);
    }
 
    @Transactional
    public void actualizarProducto(Products producto) {
        entityManager.merge(producto);
    }
    
    @Transactional
    public void actualizarUser(int userId, String hashedPassword) {
    	//EntityTransaction transaction = entityManager.getTransaction();
        try {
            
            Users user = entityManager.find(Users.class, userId);
            if (user != null) {
                user.setPassword(hashedPassword);
                entityManager.merge(user);
            }
            
        } catch (Exception e) {
          
            e.printStackTrace();
        }
       /* Users user = entityManager.find(Users.class, userId);
        if (user != null) {
            user.setPassword(users.getPassword());
            entityManager.merge(user); // Asegúrate de hacer merge después de actualizar los datos
        } else {
            throw new IllegalArgumentException("El usuario con ID " + userId + " no se encontró en la base de datos");
        }*/
    }

 
    @Transactional
    public void eliminarProducto(Long productId) {
        Products producto = entityManager.find(Products.class, productId);
        if (producto != null) {
            entityManager.remove(producto);
        }
    }
    @Transactional
    public void eliminarUser(Long userId) {
        Users user = entityManager.find(Users.class, userId);
        if (user != null) {
            entityManager.remove(user);
        }
    }
    public List<Users> obtenerTodosLosUsersBaja() {
        return entityManager.createQuery("SELECT u FROM Users u WHERE u.baja = true", Users.class).getResultList();
    }
    
    public Users buscarUsuarioPorNombreYContraseña(String nombre, String contraseña) {
        try {
            TypedQuery<Users> query = entityManager.createQuery(
                    "SELECT u FROM Users u WHERE u.name = :name", Users.class);
            query.setParameter("name", nombre);
            Users user = query.getSingleResult();

            if (user != null && BCrypt.checkpw(contraseña, user.getPassword())) {
                return user;
            } else {
                return null;
            }
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
       /*@Transactional
        public void cambiarContraseña(int userId, String hashedPassword) {
        	 EntityTransaction transaction = entityManager.getTransaction();
             try {
                 transaction.begin();
                 Users user = entityManager.find(Users.class, userId);
                 if (user != null) {
                     user.setPassword(hashedPassword);
                     entityManager.merge(user);
                 }
                 transaction.commit();
             } catch (Exception e) {
                 if (transaction.isActive()) {
                     transaction.rollback();
                 }
                 e.printStackTrace();
             }
        }*/
}