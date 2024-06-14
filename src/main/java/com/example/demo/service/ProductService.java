package com.example.demo.service;
 
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.example.demo.AboutUss;
import com.example.demo.Contacts;
import com.example.demo.Products;
import com.example.demo.Users;
import com.example.demo.dao.Dao;
 
import java.util.List;
 
@Service
public class ProductService {
    @Autowired
    private Dao dao;
    public List<Products> obtenerTodosLosProductos() {
        return dao.obtenerTodosLosProductos();
    }
    public List<Users> obtenerTodosLosUsers() {
        return dao.obtenerTodosLosUsers();
    }
    public List<AboutUss> obtenerAboutUs() {
        return dao.obtenerAboutUs();
    }
    public List<Contacts> obtenerContact() {
        return dao.obtenerContact();
    }
    public void insertarProducto(Products producto) {
        dao.insertarProducto(producto);
    }
    //Registrarse
    public void addUsers(Users users) {
    	String originalPassword = users.getPassword(); 
        String hashedPassword = hashPassword(originalPassword); 
        users.setPassword(hashedPassword); 
        
        System.out.println("Original Password: " + originalPassword);
        System.out.println("Hashed Password: " + hashedPassword);
        
        dao.addUsers(users); 
    }
    //Metodo para encriptar contraseña
    private String hashPassword(String originalPassword) {
    	return BCrypt.hashpw(originalPassword, BCrypt.gensalt());
	}
    
	public void actualizarProducto(Products producto) {
        dao.actualizarProducto(producto);
    }
	
    public void actualizarUser(Users user, int userId) {
    	String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        dao.actualizarUser(userId, hashedPassword);
        
    }
    
    public void eliminarProducto(Long productId) {
        dao.eliminarProducto(productId);
    }
    public void eliminarUsers(Long usersId) {
        dao.eliminarUser(usersId);
    }
    public List<Users> obtenerTodosLosUsersBaja() {
        return dao.obtenerTodosLosUsersBaja();
    }
    
    
    //Iniciar Sesión
    public Users buscarUsuarioPorNombreYContraseña(String nombre, String contraseña) {
    	return dao.buscarUsuarioPorNombreYContraseña(nombre, contraseña);
    }
    
	public Users buscarUsuarioPorNombre(String currentUserName) {
        // Implementación
        return null;
    }
	
	
    // Nuevo método para cambiar la contraseña
    /*public void cambiarContraseña(int userId, String nuevaContraseña) {
    	String hashedPassword = BCrypt.hashpw(nuevaContraseña, BCrypt.gensalt());
        dao.cambiarContraseña(userId, hashedPassword);
    }*/
}