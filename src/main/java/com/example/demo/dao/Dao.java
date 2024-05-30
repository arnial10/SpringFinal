package com.example.demo.dao;
 
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
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
        return entityManager.createQuery("SELECT u FROM Users u ", Users.class).getResultList();
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
    public void actualizarUserById(Users users, int userId) {
        Users user = entityManager.find(Users.class, userId);
        if (user != null) {
            user.setPassword(users.getPassword());
            entityManager.merge(user); // Asegúrate de hacer merge después de actualizar los datos
        } else {
            throw new IllegalArgumentException("El usuario con ID " + userId + " no se encontró en la base de datos");
        }
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
            return entityManager.createQuery("SELECT u FROM Users u WHERE u.name = :name AND u.password = :password", Users.class)
                    .setParameter("name", nombre)
                    .setParameter("password", contraseña)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
        @Transactional
        public void cambiarContraseña(int userId, String nuevaContraseña) {
            Users user = entityManager.find(Users.class, userId);
            System.out.println(user);
            if (user != null) {
                user.setPassword(nuevaContraseña);
            } else {
                throw new IllegalArgumentException("El usuario con ID " + userId + " no se encontró en la base de datos");
            }
    }
}