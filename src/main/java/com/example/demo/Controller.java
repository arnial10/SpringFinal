package com.example.demo;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
 
import com.example.demo.Products;
import com.example.demo.Users;
import com.example.demo.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
 
import java.io.IOException;
import java.util.List;
 
@RestController
public class Controller {
 
    @Autowired
    private ProductService productService;
 
    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Products> obtenerTodosLosProductos() {
        return productService.obtenerTodosLosProductos();
    }
 
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> obtenerTodosLosUsers() {
        return productService.obtenerTodosLosUsers();
    }
 
    @PostMapping(value = "/products/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> agregarProducto(@RequestBody Products product) {
        productService.insertarProducto(product);
		return ResponseEntity.ok("Producto agregado exitosamente.");
    }
 
    @PostMapping(value = "/users/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUsers(@RequestBody Users users) {
        productService.addUsers(users);
        return ResponseEntity.ok("Usuario agregado exitosamente.");
    }
 
    @PutMapping(value = "/products/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarProducto(@RequestBody Products producto) {
    	System.out.println("holaa");
        productService.actualizarProducto(producto);
        return ResponseEntity.ok("Producto actualizado exitosamente.");
    }
 
    @PutMapping(value = "/users/update/{usersId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarUser(@RequestBody Users users, @PathVariable int usersId) {
        productService.actualizarUser(users, usersId); // Cambia el método aquí
        return ResponseEntity.ok("Usuario actualizado exitosamente.");
    }

 
    // Cambiar contraseña de usuario
    @PutMapping(value = "/users/change-password/{userId}", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> cambiarContraseña(@PathVariable int userId, @RequestBody String nuevaContraseña) {
        try {
            productService.cambiarContraseña(userId, nuevaContraseña);
            return ResponseEntity.ok("Contraseña cambiada exitosamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
 
    @DeleteMapping(value = "/products/delete/{productId}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long productId) {
        productService.eliminarProducto(productId);
        return ResponseEntity.ok("Producto eliminado exitosamente.");
    }
 
    @DeleteMapping(value = "/users/delete/{userId}")
    public ResponseEntity<String> eliminarUsers(@PathVariable Long userId) {
        productService.eliminarUsers(userId);
        return ResponseEntity.ok("Usuario eliminado exitosamente.");
    }
 
 
    @GetMapping(value = "/users/baja", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> obtenerTodosLosUsersBaja() {
        return productService.obtenerTodosLosUsersBaja();
    }
 
    @GetMapping(value = "/users/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarUsuarioPorNombreYContraseña(@RequestParam String name, @RequestParam String password) {
        if (name == null || password == null) {
            return ResponseEntity.badRequest().body("Los parámetros 'name' y 'password' son obligatorios.");
        }
 
        Users usuario = productService.buscarUsuarioPorNombreYContraseña(name, password);
    	System.out.println(usuario.toString());

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas.");
        }
    }
}